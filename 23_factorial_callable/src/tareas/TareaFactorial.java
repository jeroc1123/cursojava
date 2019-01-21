package tareas;

import java.util.concurrent.Callable;

public class TareaFactorial implements Callable<Long> {
	
	private int numero;
	

	public TareaFactorial(int numero) {
		this.numero = numero;
	}

	@Override
	public Long call(){
		long res=1;
		for(int i=1;i<=numero;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res*=i;
		}
		return res;
	}

}
