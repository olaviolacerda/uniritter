//1.Criar duas threads (além da principal). Cada uma das threads deve repetir várias vezes "imprimir mensagem / dormir"

package exercicios_grau_a.threads;

public class ThreadMessage {
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				System.out.println("paralelos");
				try {
					Thread.sleep(150);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("distribuidos");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
