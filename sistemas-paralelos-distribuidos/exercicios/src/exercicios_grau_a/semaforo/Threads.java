package exercicios_grau_a.semaforo;

import exercicios_grau_a.semaforo.Semaforo;

public class Threads {
	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		Thread produtora = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				semaforo.put(i);
				System.out.println("Produtora 1.");
				try {
					Thread.sleep(150);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});
		
		Thread produtora2 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				semaforo.put(i);
				System.out.println("Produtora 2.");
				try {
					Thread.sleep(1000);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		Thread consumidora = new Thread(() -> {
			int num;
			for (int i = 0; i < 100; i++) {
				num = semaforo.get();
				System.out.println("Consumidora 1: " + num);
				try {
					Thread.sleep(40);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});
		
		Thread consumidora2 = new Thread(() -> {
			int num;
			for (int i = 0; i < 100; i++) {
				num = semaforo.get();
				System.out.println("Consumidora 2: " + num);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});
		
		Thread consumidora3 = new Thread(() -> {
			int num;
			for (int i = 0; i < 100; i++) {
				num = semaforo.get();
				System.out.println("Consumidora 3: " + num);
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		produtora.start();
		produtora2.start();
		consumidora.start();
		consumidora2.start();
		consumidora3.start();
		
		try {
			produtora.join();
			consumidora.join();
			System.out.println("Acabou.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
