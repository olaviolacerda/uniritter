package exercicios_grau_a.monitor;

public class Monitor {

	int np = 0, nc = 0;
	int LIMIT = 15;
	int[] buffer = new int[LIMIT];
	int size = 0;

	private boolean full() {
		return size == LIMIT;
	}

	private boolean empty() {
		return size == 0;
	}

	synchronized void put(int e) {

		while (full())
			try {
				System.out.println("Cheio.");
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		buffer[np++ % LIMIT] = e;
		size++;
		notifyAll();
	}

	synchronized int get() {
		int e;
		while (empty())
			try {
				System.out.println("Vazio.");
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		e = buffer[nc++ % LIMIT];
		size--;
		notifyAll();
		return e;
	}

}
