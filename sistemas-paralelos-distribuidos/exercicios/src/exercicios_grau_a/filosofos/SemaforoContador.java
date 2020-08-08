package exercicios_grau_a.filosofos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaforoContador {
	int TAM = 10;
	int count = TAM - 1;
	Semaphore[] hashis = new Semaphore[TAM];
	ReentrantLock mutex = new ReentrantLock();

	public SemaforoContador() {
		int i = 0;
		for (i = 0; i < TAM; i++) {
			hashis[i] = new Semaphore(1);
		}
	}

	void fazFilosofo(int i) {
		int j = 0;
		while (j < 10) {
			pensa(i);
			System.out.println(i + " parou de pensar vai pegar hashis");
			pega_hashi(i);
			System.out.println(i + " pegou os hashis e vai comer");
			come(i);
			System.out.println(i + " terminou de comer e vai liberar hashis");
			libera_hashi(i);
			System.out.println(i + " liberou hashis e vai pensar");
			try {
				Thread.sleep(50 * i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j++;
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + i + " está satisfeito.");
	}

	void pensa(int id) {
		System.out.println(id + " pensando...");
	}

	void come(int id) {
		System.out.println(id + " comendo...");
	}

	void pega_hashi(int i) {
		int esquerda = i, direita = (i + TAM - 1) % TAM;

		mutex.lock();
		while (count <= 0) {
			mutex.unlock();
			Thread.yield();
			mutex.lock();
		}
		count--;
		mutex.unlock();
		try {
			hashis[esquerda].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hashis[direita].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void libera_hashi(int i) {
		int esquerda = i, direita = (i + TAM - 1) % TAM;

		hashis[esquerda].release();
		hashis[direita].release();
		mutex.lock();
		count++;
		mutex.unlock();
	}

}
