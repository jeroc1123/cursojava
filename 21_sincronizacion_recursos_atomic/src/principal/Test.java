package principal;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

	public static void main(String[] args) {
		//No necesitamos crear una clase thread-safe, ya que AtomicInteger 
		//no devuelve el resultado hasta que termine
		AtomicInteger c=new AtomicInteger(0);
		for (int i=1;i <=50000;i++) {
			new Thread(()->c.incrementAndGet()).start();
		}
		//Usando AtomicInteger parece que si que espera el main a que termine el resto de hilos
		System.out.println("Total visitas: " + c.get());
	}
}