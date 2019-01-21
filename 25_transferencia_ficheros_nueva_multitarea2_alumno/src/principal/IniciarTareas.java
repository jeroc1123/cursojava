package principal;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import tareas.TareaFicheros;
import tareas.TareaSuma;

public class IniciarTareas {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Scanner sc=new Scanner(System.in);
		int n1, n2;
		System.out.println("Dame primer número");
		n1=sc.nextInt();
		System.out.println("Dame segundo número");
		n2=sc.nextInt();
		
		TareaFicheros t1=new TareaFicheros("numeros.txt", "f1.txt", n1);
		TareaFicheros t2=new TareaFicheros("numeros.txt", "f2.txt", n2);
		ExecutorService es=Executors.newCachedThreadPool();
		es.submit(t1);
		es.submit(t2);
		//shutdown cierra el ExecutorService segun terminan las tareas
		es.shutdown();
		es.awaitTermination(5000, TimeUnit.MILLISECONDS); //espera a que terminen el pool con un tiempo de timeout
		//otras operaciones
		System.out.println("haciendo operaciones...");
		
		ExecutorService es2=Executors.newCachedThreadPool();
		Future<Integer> f1=es2.submit(new TareaSuma("f1.txt"));
		Future<Integer> f2=es2.submit(new TareaSuma("f2.txt"));
		
		System.out.println("Suma Fichero 1: "+f1.get());
		System.out.println("Suma Fichero 2: "+f2.get());
		es2.shutdown();
	}
}