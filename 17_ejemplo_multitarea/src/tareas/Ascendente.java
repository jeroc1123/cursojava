package tareas;

public class Ascendente extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}