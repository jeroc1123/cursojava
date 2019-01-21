package principal;

class Externa3{
	int b;
	public void prueba() {
		int c;
		class Interna3{
			private int a;
			public void imprimir() {
				a=2;
				b=7;
				//c=0; //no se puede acceder a variables locales del metodo
				System.out.println("Imprimir de local");
			}
		}
		Interna3 in =new Interna3();
		in.imprimir();
	}
}

public class TestLocal {

	public static void main(String[] args) {
		//no es posible crear objetos de clases internas a objetos desde fuera de ellas

	}

}
