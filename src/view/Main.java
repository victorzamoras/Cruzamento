package view;

import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class Main {

	public static void main(String[] args) {
		final int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int id = 1; id <= 4; id++) {
			Thread t = new Cruzamento(id, semaforo);
			t.start();
		}
	}
}