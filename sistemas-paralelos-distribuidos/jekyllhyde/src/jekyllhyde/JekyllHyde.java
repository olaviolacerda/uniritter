package jekyllhyde;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//====================== MONITOR =======================
class Modificacoes {

	int np = 0, nc = 0;
	int LIMIT = JekyllHyde.alteracoes_cliente;
	int[] modificacoes = new int[LIMIT];
	int size = 0;

	private synchronized boolean full() {
		return size == LIMIT;
	}

	private synchronized boolean empty() {
		return size == 0;
	}

	synchronized void put(int e) {
		while (full())
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		modificacoes[np++ % LIMIT] = e;
		size++;

		this.notifyAll();
	}

	synchronized int get() {
		int e;
		while (empty())
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		e = modificacoes[nc++ % LIMIT];
		size--;

		this.notifyAll();
		return e;
	}

}

// ====================== ARQUIVO =======================
class Arquivo {
	int nome;
	private int tamanho = 1;
	ReentrantReadWriteLock controle_escrita_leitura;

	public Arquivo() {
	};

	public Arquivo(int id) {
		this.nome = id;
		this.controle_escrita_leitura = new ReentrantReadWriteLock();
	}

	public int getNome() {
		return nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void modifica_tamanho() {
		this.tamanho += 1;
		System.out.println("ARQUIVO: " + this.getNome() + " modificado.");
	}

}

// ====================== CLIENTE =======================
class Cliente extends Thread {

	Servidor servidor;
	ArrayList<Arquivo> diretorio;
	Tipo tipo;
	int tempo_bloqueio = 0, alteracoes = 0;

	public Cliente(Servidor servidor) {
		this.servidor = servidor;
		this.diretorio = servidor.diretorio;
		this.tipo = servidor.tipo;
	}

	public void run() {
		int posicao, vezes = 0;
		Random gera_numero = new Random();
		Arquivo arquivo_escolhido;
		while (vezes < JekyllHyde.alteracoes_cliente) {
			posicao = gera_numero.nextInt(JekyllHyde.quantidade_arquivos - 1);
			arquivo_escolhido = diretorio.get(posicao);
			try {
				arquivo_escolhido.controle_escrita_leitura.writeLock().lock();
				arquivo_escolhido.modifica_tamanho();

				sleep(arquivo_escolhido.getTamanho());
				this.tempo_bloqueio += arquivo_escolhido.getTamanho();

				arquivo_escolhido.controle_escrita_leitura.writeLock().unlock();
				System.out.println("CLIENTE: " + tipo + " modificou o tamanho do arquivo " + posicao + " para "
						+ diretorio.get(posicao).getTamanho() + ".");
				servidor.monitor.put(posicao);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			vezes++;
			alteracoes++;
		}
	}

	public String getTempoBloqueado() {
		return "Cliente  " + this.tipo.toString() + " realizou " + alteracoes + " alterações e ficou bloqueado por "
				+ this.tempo_bloqueio;
	}

}

// ====================== SERVIDOR =======================
class Servidor extends Thread {
	ArrayList<Arquivo> diretorio, outro_diretorio;
	Tipo tipo;
	Modificacoes monitor;
	int tempo_bloqueio = 0, sincronizacoes = 0;

	public Servidor(Tipo tipo, Modificacoes monitor, ArrayList<Arquivo> diretorio, ArrayList<Arquivo> outro_diretorio) {
		this.tipo = tipo;
		this.monitor = monitor;
		this.diretorio = diretorio;
		this.outro_diretorio = outro_diretorio;
	}

	void sincroniza(int posicao) {
		this.sincronizacoes += 1;
		switch (this.tipo) {
		case JEKYLL:
			System.out.println("SERVIDOR: Sincronizando JEKYLL.");
			try {
				diretorio.get(posicao).controle_escrita_leitura.readLock().lock();
				outro_diretorio.get(posicao).controle_escrita_leitura.writeLock().lock();

				sleep(diretorio.get(posicao).getTamanho());
				this.tempo_bloqueio += diretorio.get(posicao).getTamanho();

				diretorio.get(posicao).controle_escrita_leitura.readLock().unlock();
				outro_diretorio.get(posicao).controle_escrita_leitura.writeLock().unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("SERVIDOR: Fim sincronização JEKYLL.");
			break;
		case HYDE:
			System.out.println("SERVIDOR: Sincronizando HYDE.");
			try {
				diretorio.get(posicao).controle_escrita_leitura.writeLock().lock();
				outro_diretorio.get(posicao).controle_escrita_leitura.readLock().lock();

				sleep(diretorio.get(posicao).getTamanho());
				this.tempo_bloqueio += diretorio.get(posicao).getTamanho();

				diretorio.get(posicao).controle_escrita_leitura.writeLock().unlock();
				outro_diretorio.get(posicao).controle_escrita_leitura.readLock().unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("SERVIDOR: Fim sincronização HYDE.");
			break;

		}
	}

	public void run() {
		int vezes = 0, posicao;
		do {
			posicao = this.monitor.get();
			sincroniza(posicao);
			System.out.println("SERVIDOR: " + tipo.toString() + " tratou a modificação do arquivo " + posicao);
			vezes = vezes + 1;
		} while (vezes < JekyllHyde.alteracoes_cliente);
	}

	public String getTempoBloqueado() {
		return "Servidor " + this.tipo.toString() + " fez " + sincronizacoes + " sincronizações e ficou bloqueado por "
				+ this.tempo_bloqueio;
	}

}

// ====================== HTTP =======================
class HTTP extends Thread {

	int id;
	Servidor jekyll;
	Servidor hyde;
	private int tempo_bloqueio = 0;

	public HTTP(int id, Servidor jekyll, Servidor hyde) {
		this.id = id;
		this.jekyll = jekyll;
		this.hyde = hyde;
	}

	public void run() {
		Random gera_numero = new Random();
		Random gera_posicao = new Random();
		Random escolhe_servidor = new Random();
		int vezes = 0;
		while (vezes < JekyllHyde.requisicoes_http) {
			if (escolhe_servidor.nextInt(10) < 5) {
				if (gera_numero.nextInt(1) == 0) {
					this.controla_leitura(jekyll.diretorio, gera_posicao.nextInt(JekyllHyde.quantidade_arquivos - 1),
							jekyll.tipo);
				} else {
					this.controla_leitura(jekyll.outro_diretorio,
							gera_posicao.nextInt(JekyllHyde.quantidade_arquivos - 1), jekyll.tipo);
				}
			} else {
				if (gera_numero.nextInt(1) == 0) {
					this.controla_leitura(hyde.diretorio, gera_posicao.nextInt(JekyllHyde.quantidade_arquivos - 1),
							hyde.tipo);
				} else {
					this.controla_leitura(hyde.outro_diretorio,
							gera_posicao.nextInt(JekyllHyde.quantidade_arquivos - 1), hyde.tipo);
				}
			}
			vezes = vezes + 1;
		}
	}

	public void controla_leitura(ArrayList<Arquivo> diretorio, int posicao, Tipo tipo) {
		Arquivo arquivo_escolhido = diretorio.get(posicao);
		int tamanho = arquivo_escolhido.getTamanho();
		try {
			arquivo_escolhido.controle_escrita_leitura.readLock().lock();

			sleep(tamanho);
			this.tempo_bloqueio += tamanho;

			System.out.println("HTTP: " + this.id + " realizou leitura no arquivo " + posicao + " no servidor " + tipo);
			arquivo_escolhido.controle_escrita_leitura.readLock().unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getTempoBloqueado() {
		return "Worker HTTP " + this.id + " ficou bloqueado por " + this.tempo_bloqueio;
	}
}

// ====================== MAIN =======================
public class JekyllHyde {
	public static Scanner teclado = new Scanner(System.in);
	static {
		System.out.println("JEKYLLHYDE - TRABGA - OLAVIO LACERDA");
	}

	static {
		System.out.println("Digite a quantidade de arquivos: \n");
	}
	public static int quantidade_arquivos = teclado.nextInt();
	static {
		System.out.println("Digite a quantidade de alterações de cada Cliente: \n");
	}
	public static int alteracoes_cliente = teclado.nextInt();
	static {
		System.out.println("Digite a quantidade de workers HTTP: \n");
	}
	public static int quantidade_http = teclado.nextInt();
	static {
		System.out.println("Digite a quantidade de requisições de cada workers HTTP: \n");
	}
	public static int requisicoes_http = teclado.nextInt();

	public static Modificacoes modificacoesJekyll = new Modificacoes();
	public static Modificacoes modificacoesHyde = new Modificacoes();

	public static void main(String[] args) {

		ArrayList<Arquivo> arquivos = new ArrayList<Arquivo>();
		ArrayList<Arquivo> arquivos2 = new ArrayList<Arquivo>();
		ArrayList<HTTP> requisicoes = new ArrayList<HTTP>();

		for (int i = 0; i < quantidade_arquivos; i++) {
			arquivos.add(new Arquivo(i));
			arquivos2.add(new Arquivo(i));
		}

		Servidor jekyll = new Servidor(Tipo.JEKYLL, modificacoesJekyll, arquivos, arquivos2);
		Servidor hyde = new Servidor(Tipo.HYDE, modificacoesHyde, arquivos2, arquivos);
		Cliente cliente_jekyll = new Cliente(jekyll);
		Cliente cliente_hyde = new Cliente(hyde);

		for (int i = 0; i < quantidade_http; i++) {
			requisicoes.add(new HTTP(i, jekyll, hyde));
		}

		jekyll.start();
		hyde.start();
		cliente_jekyll.start();
		cliente_hyde.start();

		for (HTTP requisicao : requisicoes) {
			requisicao.start();
		}

		try {
			for (HTTP requisicao : requisicoes) {
				requisicao.join();
			}
			jekyll.join();
			hyde.join();
			cliente_jekyll.join();
			cliente_hyde.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n\n\n--------------------- Tempo de bloqueio de cada Thread ---------------------");
		System.out.println("=======================================================================");
		System.out.println("-------------------------------- SERVIDORES --------------------------------\n"
				+ jekyll.getTempoBloqueado() + "\n" + hyde.getTempoBloqueado() + "\n");
		System.out.println("=======================================================================");
		System.out.println("--------------------------------- CLIENTES ---------------------------------\n"
				+ cliente_jekyll.getTempoBloqueado() + "\n" + cliente_hyde.getTempoBloqueado() + "\n");
		System.out.println("=======================================================================");
		System.out.println("--------------------------------- WORKERS ----------------------------------\n");
		for (HTTP requisicao : requisicoes) {
			System.out.println(requisicao.getTempoBloqueado());
		}
		System.out.println("----------------------------------- Fim -------------------------------------------");
	}
}
