package hash.table;

import java.util.ArrayList;
import java.util.HashMap;

public class Servidor {

	private Comm comm;
	private ArrayList<Integer> clientes = new ArrayList<>();
	private HashMap<String, ValueHash> hm = new HashMap<>();

	public Servidor(ArrayList<Integer> clientes, Comm comm) {
		this.comm = comm;
		this.clientes = clientes;
		hm.put("RS", new ValueHash("POA"));
	}

	public void run() {
		for (Integer cliente : clientes) {

			Thread thread_clientes = new Thread(() -> {
				
				boolean continua = true;
				while (continua) {
					try {
						
						Object msg = comm.recvFrom(cliente);

						//System.out.println("Mensagem: " + msg);
						
						synchronized (comm) {
							 if (msg instanceof GetMsg) {
								GetMsg getMsg = (GetMsg) msg;
								ValueHash item = hm.get(getMsg.getKey());									
								comm.sendTo(cliente, new GetReply(item));
					
							} else if (msg instanceof PutMsg) {
								PutMsg putMsg = (PutMsg) msg;	
								
								hm.put(putMsg.getKey(), putMsg.getItem());
							} else if (msg instanceof QuitMsg) {
								continua = false;
							}
						}
					} catch (Exception e) {						
						continua = false;
					}
				}
			});
			thread_clientes.start();
		}
	}
	

}
