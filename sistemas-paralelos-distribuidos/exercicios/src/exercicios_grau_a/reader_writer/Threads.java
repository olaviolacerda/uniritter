package exercicios_grau_a.reader_writer;

public class Threads {

	public static void main(String[] args) {

		ReaderWriter rw = new ReaderWriter();

		Thread leitor1 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				rw.reader(1);
				try {
					Thread.sleep(150);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		Thread escritor1 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				rw.writer(1);
				try {
					Thread.sleep(100);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		Thread escritor2 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				rw.writer(2);
				try {
					Thread.sleep(20);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		Thread leitor2 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				rw.reader(2);
				try {
					Thread.sleep(50);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		Thread escritor3 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				rw.writer(3);
				try {
					Thread.sleep(170);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		leitor1.start();
		leitor2.start();
		escritor1.start();
		escritor2.start();
		escritor3.start();

		try {
			leitor1.join();
			leitor2.join();
			escritor1.join();
			escritor2.join();
			escritor3.join();
			rw.c = 0;
			System.out.println("Acabou.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
