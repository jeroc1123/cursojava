package tareas;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class TareaSuma extends RecursiveTask<Integer> {
	private List<Integer> lista;
	private int ini;
	private int fin;
	private final int LIMITE=3;
	int sum=0;
	
	public TareaSuma(List<Integer> lista, int ini, int fin) {
		this.lista = lista;
		this.ini = ini;
		this.fin = fin;
	}



	@Override
	protected Integer compute() {
		System.out.println(ini+":"+fin);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((fin-ini)<LIMITE) {
			for(int i=ini;i<=fin;i++) {
				sum+=lista.get(i);
			}
			return sum;
		}else {
			int mid=ini+(fin-ini)/2;
			TareaSuma t1=new TareaSuma(lista,ini,mid);
			t1.fork();
			TareaSuma t2=new TareaSuma(lista,mid+1,fin);
			t2.fork();
			return t1.join()+t2.join();
		}
	}

}
