package hash.table;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;

public class Machine {
	public int id;
	public String alias;
	public String tcp_net_address;
	public int tcp_port;
	public Socket sock;

	public static Machine[] parseFile(Path p) {
		ArrayList<Machine> machines = new ArrayList<>();

		try (Scanner s = new Scanner(p)) {
			while (s.hasNextLine()) {
				String l = s.nextLine();
				String[] fields = l.split(" ");
				if (fields.length < 3) {
					System.err.printf("Formato: id endereco porta <alias>");
					return null;
				}

				Machine m = new Machine();
				m.id = Integer.parseInt(fields[0]);
				m.tcp_net_address = fields[1];
				m.tcp_port = Integer.parseInt(fields[2]);

				if (fields.length > 3)
					m.alias = fields[3];
				else
					m.alias = new Integer(m.id).toString();

				machines.add(m);
			}
		} catch (IOException e) {
			return null;
		}

		Machine[] ret = new Machine[machines.size()];
		return machines.toArray(ret);
	}
}
