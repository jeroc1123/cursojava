package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import beans.Contador;

public class Test {

	public static void main(String[] args) {
		Contador c=new Contador(0);

		Runnable t1=()->c.incrementar();
		Runnable t2=()->c.incrementar();
		Runnable t3=()->c.incrementar();

		ExecutorService es=Executors.newCachedThreadPool();

		Future<?> f1=es.submit(t1);
		Future<?> f2=es.submit(t2);
		Future<?> f3=es.submit(t3);
		//indicamos que espere sin hacer nada hasta que terminen los hilos
		while (!f1.isDone()&&!f2.isDone()&&!f3.isDone()) {}

		System.out.println("Total visitas: " + c.getValor());

		es.shutdown();
	}

}
