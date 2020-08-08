import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import org.omg.CORBA.portable.UnknownException;

public class Cliente {
	public static void main(String[] args) throws UnknownException, IOException {
		Socket cliente = new Socket("127.0.0.1", 4444);

		Scanner entrada = new Scanner(cliente.getInputStream());

		while (entrada.hasNextLine()) {
			System.out.println(entrada.nextLine());
		}

		entrada.close();
	}
}
