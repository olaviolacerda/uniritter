package hash.table;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Path;

class HelloMsg implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4978985853799440049L;
	public int id;
}


class MessageReceiveError {
    public String reason;
}

public class Comm
{
    private final HashMap<Integer, Machine> id_to_machine_map = new HashMap<>();
    private final HashMap<String, Machine> alias_to_machine_map = new HashMap<>();

    private Machine me;
    public Machine[] neighbors;

    public static Comm init(int my_id, String machinefile)
    {
        Path p = Paths.get(machinefile);

        Machine[] machine_array = Machine.parseFile(p);
        if (machine_array == null)
            return null;

        try {
            return new Comm(my_id, machine_array);
        } catch (Exception e) {
            //System.err.println("Erro criando comm: " + e.toString());
            return null;
        }
    }

    public Comm(int my_id, Machine[] machines) throws Exception
    {
        for(Machine m: machines )
        {
            if (id_to_machine_map.containsKey(m.id)) {
                throw new Exception("Id duplicado" + m.id);
            } else if (alias_to_machine_map.containsKey(m.alias)) {
                throw new Exception("Alias duplicado: " + m.alias);
            }

            id_to_machine_map.put(m.id, m);
            alias_to_machine_map.put(m.alias, m);
        }

        if (!id_to_machine_map.containsKey(my_id)) {
            throw new Exception("Id " + my_id + " não aparece no arquivo de máquinas");
        }

        this.me = id_to_machine_map.get(my_id);
        this.me.sock = null;

        neighbors = machines;
        Arrays.sort(neighbors,
                    (Machine a, Machine b) -> {
                        return a.id - b.id;
                    });

        ConnectThread connect_thread = new ConnectThread(this);
        connect_thread.start();
        boolean success = this.start_listen();
        connect_thread.join();

        if (!success || !connect_thread.connected())
            throw new Exception("Falhou na conexão");
        // for (int i = 0; i < neighbors.length; i++) {
        //     if (neighbors[i].id == me.id)
        //     {
        //         System.out.println("Pos " + i + ": myself");
        //     } else if (neighbors[i].sock == null) {
        //         System.out.println("Pos " + i +
        //                            " id " + neighbors[i].id +
        //                            ": not connected");
        //     } else
        //         System.out.println("Pos " + i +
        //                            " id " + neighbors[i].id +
        //                            ": connected");
        // }
    }

    @SuppressWarnings("resource")
    private boolean start_listen() {

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(me.tcp_port);

            int next;
            for (next = 0;
                 next < neighbors.length && neighbors[next].id != me.id;
                 next++)
            {
                //System.out.println("Esperando hello " + next);
                try {
                    Socket s = ss.accept();
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

                    try {
                        HelloMsg h = (HelloMsg)ois.readObject();
                        //System.out.println("Hello de " + h.id);

                        Machine m = id_to_machine_map.get(h.id);
                        if (m == null)
                        {
                            //System.out.println("Hello de maquina desconhecida: " + h.id);
                            return false;
                        }

                        //System.out.println("Hello de " + h.id);

                        m.sock = s;
                    } catch (IOException e) {
                        System.out.println("Erro recebendo hello: " + e);
                        return false;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Bug feio: " + e);
                        return false;
                    }
                } catch(IOException e) {
                    System.err.println("Erro de accept : " + e.toString());
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exceção genérica no accept:" + e);
            return false;
        }

        return true;
    }

    @SuppressWarnings("resource")
    public boolean start_connect() {
        // encontra esse servidor no vetor de vizinhos
        int next;
        for (next = 0;
             next < neighbors.length && neighbors[next].id <= me.id;
             next++);

        for (; next < neighbors.length; next++) {
            Machine nextMachine = neighbors[next];
            nextMachine.sock = null;

            //System.out.println("Mandando hello para " + nextMachine.id);

            HelloMsg m = new HelloMsg();
            m.id = me.id;

            for (int ntry = 0; ntry < 10; ntry++) {
                try {
                    Socket s = new Socket(nextMachine.tcp_net_address, nextMachine.tcp_port);
                    // send a hello msg
                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

                    try {
                        out.writeObject(m);
                        nextMachine.sock = s;
                        break; // conectou, para de tentar
                    } catch (IOException e) {
                        System.err.println("Erro mandando hello para " + nextMachine.id + ": " + e.toString());
                        return false;
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao conectar com " + nextMachine.tcp_net_address + "(" + ntry + " / 10)");
                }

                // Dorme antes de tentar de novo
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }

            // Depois do for ntry:
            if (nextMachine.sock == null)
            {
                System.err.println("Não conseguiu conectar com " + nextMachine.tcp_net_address);
                return false;
            }
        }

        return true;
    }

    public CompletableFuture<Boolean>
    asyncSendTo(Machine target, Object msg) throws IOException
    {
        if (target == null)
            throw new IOException("Null target on send");

        if (target.id == me.id)         	
        	throw new IOException("N�o � poss�vel enviar para si mesmo ");
           

        try {
            OutputStream os = target.sock.getOutputStream();
            CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        synchronized(os) {
                            ObjectOutputStream out = new ObjectOutputStream(os);
                            out.writeObject(msg);
                            //System.out.println("Enviou");
                        }
                    } catch(Exception e) {
                        return false;
                    }
                    return true;
                });
            return future;
        } catch(Exception e) {
            throw new IOException("Erro enviando msg do tipo " +
                                  msg.getClass().getName() +
                                  " para " + target.id
                                  );
        }
    }

    public CompletableFuture<Boolean>
    asyncSendTo(int id, Object msg) throws IOException
    {
        return asyncSendTo(id_to_machine_map.get(id), msg);
    }

    public CompletableFuture<Boolean>
    asyncSendTo(String alias, Object msg) throws IOException
    {
        return asyncSendTo(alias_to_machine_map.get(alias), msg);
    }

    public boolean
    sendTo(Machine target, Object msg) throws IOException
    {
        return this.asyncSendTo(target, msg).join();
    }

    public boolean sendTo(int id, Object msg) throws IOException
    {
        return sendTo(id_to_machine_map.get(id), msg);
    }

    public boolean sendTo(String alias, Object msg) throws IOException
    {
        return sendTo(alias_to_machine_map.get(alias), msg);
    }

    public CompletableFuture<Object>
    asyncRecvFrom(Machine target) throws IOException
    {
        if (target == null)
            throw new IOException("Null target on recv");

        if (target.id == me.id)
            throw new IOException("Não é possível recever de si mesmo ");

        try {
            InputStream is = target.sock.getInputStream();
            CompletableFuture<Object> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        synchronized(is) {
                            ObjectInputStream in = new ObjectInputStream(is);
                            return in.readObject();
                        }
                    } catch(Exception e) {
                        MessageReceiveError me = new MessageReceiveError();
                        me.reason = e.toString();
                        return me;
                    }
                });
            return future;
        } catch(Exception e) {
            throw new IOException("Erro recebendo mensagem de" +
                                   target.id);
        }
    }

    public Object
    recvFrom(Machine target) throws IOException
    {
        return asyncRecvFrom(target).join();
    }

    public CompletableFuture<Object>
    asyncRecvFrom(int id) throws IOException
    {
        return asyncRecvFrom(id_to_machine_map.get(id));
    }

    public CompletableFuture<Object>
    asyncRecvFrom(String alias) throws IOException
    {
        return asyncRecvFrom(alias_to_machine_map.get(alias));
    }

    public Object recvFrom(int id) throws IOException
    {
        return recvFrom(id_to_machine_map.get(id));
    }

    public Object recvFrom(String alias) throws IOException
    {
        return recvFrom(alias_to_machine_map.get(alias));
    }

    public String getAlias() {
        return me.alias;
    }

    public int getId() {
        return me.id;
    }

    public int getSize() {
        return neighbors.length;
    }

}

class ConnectThread extends Thread {
    private Comm comm;
    private boolean success;

    public ConnectThread(Comm c) {
        this.comm = c;
        success = false;
    }

    public void run() {
        success = comm.start_connect();
    }

    public boolean connected() {
        return success;
    }
}
