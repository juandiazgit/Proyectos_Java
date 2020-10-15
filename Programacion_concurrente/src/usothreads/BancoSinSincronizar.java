package usothreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		
		Banco b = new Banco();
		
		for (int i = 0; i < 100; i++) {
			EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}

	}

}

class Banco {

	private final double cuentas[];
//	private Lock cierreBanco = new ReentrantLock();
//	private Condition saldoSuficiente;

	public Banco() {

		cuentas = new double[100];

		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}

//		saldoSuficiente = cierreBanco.newCondition();
		
	}

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

//		cierreBanco.lock(); //Realiza un bloque para que solamente se ejecute el Hilo actual
		
//		try {
			
		while (cuentas[cuentaOrigen] < cantidad) { // Evalúa que el saldo no es inferior a la transferencia
						
//				saldoSuficiente.await();
			wait();
			System.err.println(Thread.currentThread()); 
//				return;
		}

		System.out.println(Thread.currentThread());

		cuentas[cuentaOrigen] -= cantidad; // Dinero que sale de la cuenta origen

		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

		cuentas[cuentaDestino] += cantidad;

		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
			
//			saldoSuficiente.signalAll();
		notifyAll();
			
//		} finally {
//			
//			cierreBanco.unlock(); //Realiza el desbloqueo para se ejecute el siguiente Hilo
//			
//		}

	}

	/*
	 * Método que devuelve el saldo total de todas las cuentas del Banco
	 */
	public double getSaldoTotal() {

		double suma_cuentas = 0;

		for (double a : cuentas) {

			suma_cuentas += a;

		}

		return suma_cuentas;
	}

}

class EjecucionTransferencias implements Runnable {

	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;

	public EjecucionTransferencias(Banco b, int de, double max) {

		this.banco = b;
		this.deLaCuenta = de;
		this.cantidadMax = max;

	}

	@Override
	public void run() {

		try {
			while (true) {

				int paraLaCuenta = (int) (100 * Math.random());
				double cantidad = cantidadMax * Math.random();

				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

				Thread.sleep((int) (Math.random()*10));

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
