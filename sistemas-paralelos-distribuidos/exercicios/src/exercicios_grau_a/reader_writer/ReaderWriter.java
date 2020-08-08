package exercicios_grau_a.reader_writer;

import java.util.concurrent.Semaphore;

public class ReaderWriter {
	int readcount = 0, tempo = 10, c = 0;
	Semaphore fila = new Semaphore(1), recurso = new Semaphore(1), roleta = new Semaphore(1);

	void reader(int id) {
		do {
			System.out.println("LOCK reading " + id);

			try {
				roleta.acquire();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			roleta.release();
			try {
				fila.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (++readcount == 1) {
				try {
					recurso.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fila.release();
			System.out.println(" reading " + id);
			try {
				fila.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (--readcount == 0) {
				recurso.release();
			}
			System.out.println("UNLOCKED read " + id);
			fila.release();
			c++;
		} while (c < tempo);
	}

	void writer(int id) {
		do {
			System.out.println("LOCK Write " + id);

			try {
				roleta.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Writing" + id);
			try {
				recurso.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			roleta.release();
			System.out.println("UNLOCK Write " + id);
			recurso.release();
			c++;
		} while (c < tempo);
	}
}
