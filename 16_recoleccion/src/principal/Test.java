package principal;

class Prueba {
	
}

public class Test {

	public static void main(String[] args) {
		Prueba p1=new Prueba();
		metodo(p1);
		Prueba p2 =p1;
		p1=null;
		System.out.println("hello");

	}
	static void metodo(Prueba r) {
		r=null;
	}

}
