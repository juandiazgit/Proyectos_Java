package usothreads;

public class SincronizandoHilos {

	public static void main(String[] args) {
	
		HilosVarios hilo1 = new HilosVarios();

		/*try {
			hilo1.join(); //Este hilo1 se ejecutará hasta que finalice, para que inicie el hilo2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		HilosVarios2 hilo2 = new HilosVarios2(hilo1);
		
		hilo2.start();
		hilo1.start();
		
		System.out.println("Terminadas las tareas");

	}

}

class HilosVarios extends Thread{

	@Override
	public void run() {

		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo "+this.getName());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}

class HilosVarios2 extends Thread{
	
	private Thread hilo;
	
	public HilosVarios2(Thread hilo) {

		this.hilo = hilo;
		
	}

	@Override
	public void run() {
		
		try {
			this.hilo.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo "+this.getName());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
