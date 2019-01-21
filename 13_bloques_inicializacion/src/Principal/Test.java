package Principal;

class Prueba {
	int a;
	static int b;
	public Prueba() {
		System.out.println("constructor");
	}

	{
		System.out.println("Bloque inicializacion");
	}
	static {
		System.out.println("Bloque inicializacion estatico");
	}
}

public class Test {
	public static void main(String[] args) {
		/*Prueba p1 = new Prueba();
		Prueba p2 = new Prueba();*/
		Prueba.b=2;
		Prueba.b=4;
	}
}
