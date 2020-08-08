package hash.table;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> clientes = new ArrayList<>();
		ArrayList<Integer> servidores = new ArrayList<>();

		if (args.length < 2)
			return;

		Comm comm = Comm.init(new Integer(args[0]).intValue(), args[1]);

		if (comm == null) {
			System.out.println("Não inicializou\n");
			return;
		}
		System.out.println("Inicializou! " + comm.getAlias());

		for (Machine m : comm.neighbors) {

			if (m.alias.startsWith("server")) {
				servidores.add(m.id);
			}

			else {
				clientes.add(m.id);
			}
		}

		
			if (comm.getAlias().startsWith("server")) {
				Servidor server = new Servidor(clientes, comm);
				server.run();
			} else {
				Cliente cliente = new Cliente(servidores, comm);
				cliente.run();
			}
		

	}
}
