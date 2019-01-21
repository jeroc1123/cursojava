package beans;

public class Contador {
	private Integer valor;
	public Contador (Integer valor) {
		this.valor=valor;
	}
	public synchronized void incrementar () {
		//synchronized(valor) es lo mismo, solo que al bloquear todo el metodo "public synchronized"
		//bloqueas todo el objeto.
		int e=valor;
		e++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		valor=e;
	}
	public Integer getValor() {
		return valor;
	}
}