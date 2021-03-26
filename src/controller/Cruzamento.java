package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {
	private int id = 1;
	private Semaphore semaforo;
	
	public Cruzamento(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		try {
			semaforo.acquire();
			carros();
			sleep(6000);
			System.out.println("Carro " +id+ " passou o cruzamento");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	public void carros() {
	if (id% 4 == 0) {
		System.out.println("Carro " +id+ " está indo para o norte");
		}
	else if (id% 4 == 1) {
		System.out.println("Carro " +id+ " está indo para o sul");
	}
	else if(id% 4 ==2) {
		System.out.println("Carro " +id+ " está indo para o leste");
	}
	else
		System.out.println("Carro " +id+ " está indo para o oeste");
	}
}
