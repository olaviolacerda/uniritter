package exercicios_grau_a.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Semaforo {

	int np = 0, nc = 0;
	int LIMIT = 15;
	int[] buffer = new int[LIMIT];
	int size = 0;

	ReentrantLock mutex = new ReentrantLock();
	Semaphore empty = new Semaphore(LIMIT);
	Semaphore fill = new Semaphore(0);

	void put(int e) {
		try {
			empty.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		mutex.lock();
		buffer[np++ % LIMIT] = e;
		mutex.unlock();
		fill.release();
	}

	int get() {
		int e;
		try {
			fill.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		mutex.lock();
		e = buffer[nc++ % LIMIT];
		mutex.unlock();
		empty.release();
		return e;
	}

}
