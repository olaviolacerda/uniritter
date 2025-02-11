//2.Criar duas threads. A primeira faz alguma tarefa (e.g. mensagem/dormir) e depois deve esperar que a segunda "avise" que outra tarefa foi concluída. Usando SYNCH
package exercicios_grau_a.threads;

public class ThreadSynchronized{

//	public boolean done = false;
	
	int done = 0;
	
	synchronized void hold(){
		while(done == 0){
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	synchronized void setDone(int value){
		done = value;
		notify();
	}

	public static void main(String[] args){

		ThreadSynchronized sync = new ThreadSynchronized();
		
		
		Thread t1 = new Thread(() -> {

			System.out.println("Eu sou a T1, comecei...");
			for (int i = 0; i < 13; i++) {
				System.out.println("paralelos");
				try {
					Thread.sleep(10);

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			System.out.println("Estou esperando...");
			sync.hold();
			
			System.out.println("Eu sou a T1, terminei!");
		});

		Thread t2 = new Thread(() -> {
			
			System.out.println("Eu sou a T2, comecei...");
			for (int i = 0; i < 3; i++) {
				System.out.println("distribuidos");
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			
			
			sync.setDone(1);
			System.out.println("Eu sou a T2, Terminei!!");
		});

		t1.start();
		t2.start();

		try {
			
			t1.join();
			t2.join();
			System.out.println("DO------------NE");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
