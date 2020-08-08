
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {

		ServerSocket servidor = new ServerSocket(1234);
		System.out.println("Porta 1234 aberta!");

		while (true) {

			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com cliente " + cliente.getInetAddress().getHostAddress());

			InputStream is = new FileInputStream("arquivo.txt");
			Scanner entrada = new Scanner(is);
			PrintStream saida = new PrintStream(cliente.getOutputStream());

			while (entrada.hasNextLine()) {
				saida.println(entrada.nextLine());
			}

			saida.close();
			entrada.close();
		}
	}
}
