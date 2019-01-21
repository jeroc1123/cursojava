package principal;

import beans.Contador;

public class Test {

	public static void main(String[] args) {
		Contador c=new Contador(0);
		Runnable t1=()->c.incrementar();
		Runnable t2=()->c.incrementar();
		Runnable t3=()->c.incrementar();
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Total visitas: " + c.getValor());
	}

}
