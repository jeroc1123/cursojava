package beans;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
	private Integer valor;
	private static Lock lc;
	static {
		lc = new ReentrantLock();
	}

	public Contador(Integer valor) {
		this.valor = valor;
	}

	public void incrementar() {
		try {
			lc.lock();
			int e = valor;
			e++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
			valor = e;
		} finally {
			lc.unlock();
		}
	}

	public Integer getValor() {
		return valor;
	}

}