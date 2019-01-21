package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tareas.TareaFactorial;

public class TestFactoriales {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es=Executors.newCachedThreadPool();
		Future<Long> f1=es.submit(new TareaFactorial(5));
		Future<Long> f2=es.submit(new TareaFactorial(8));
		Future<Long> f3=es.submit(new TareaFactorial(4));
		
		while(!f1.isDone()||!f2.isDone()||!f3.isDone()) {
			System.out.println("haciendo cosas....");
		}
		System.out.println("Factorial de 5: "+f1.get());
		System.out.println("Factorial de 8: "+f2.get());
		System.out.println("Factorial de 4: "+f3.get());
		es.shutdown();
	}

}
