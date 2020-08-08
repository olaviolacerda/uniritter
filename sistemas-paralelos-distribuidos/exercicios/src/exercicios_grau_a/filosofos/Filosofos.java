package exercicios_grau_a.filosofos;

public class Filosofos {

	public static void main(String[] args) {
		// SemaforoContador semaforo = new SemaforoContador();
		Assimetrico semaforo = new Assimetrico();

		Thread beristoteles = new Thread(() -> {
			semaforo.fazFilosofo(0);
		});

		Thread aristoteles = new Thread(() -> {
			semaforo.fazFilosofo(1);
		});

		Thread platao = new Thread(() -> {
			semaforo.fazFilosofo(2);
		});

		Thread socrates = new Thread(() -> {
			semaforo.fazFilosofo(3);
		});
		Thread decarte = new Thread(() -> {
			semaforo.fazFilosofo(4);
		});

		beristoteles.start();
		aristoteles.start();
		platao.start();
		socrates.start();
		decarte.start();

		try {
			beristoteles.join();
			aristoteles.join();
			platao.join();
			socrates.join();
			decarte.join();
			System.out.println("Todos os filósofos comeram, agora podem continuar vadian...digo, pensando.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
