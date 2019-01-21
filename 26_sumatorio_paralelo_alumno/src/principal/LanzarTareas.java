package principal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import tareas.TareaSuma;

public class LanzarTareas {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Integer> lista=Arrays.asList(7,9,2,4,5,3,10,14,1);
		TareaSuma t=new TareaSuma(lista,0,lista.size()-1);
		//lanzamiento de la tarea principal
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(t); //Ya devuelve el resultado, no es necesario meter el t.get() de la Suma final
						//Todo el manejo del ExecutionService se hace por debajo... submit(), shutdown()
		System.out.println("Suma final: "+ t.get());
	}
}