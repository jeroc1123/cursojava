package principal;

class Externa1{
	private int b;
	private int a;
	class Interna1{
		int a;
		public void imprimir() {
			System.out.println("Interna Estandar");
			b=10;
			a=6; //se refiere a la a interna
			Externa1.this.a =4; // a la a de la externa
			Interna1.this.a =5;
		}
	}
	public void prueba() {
		Interna1 n=new Interna1();
	}
}

public class TestEstandares {

	public static void main(String[] args) {
		Externa1 ex=new Externa1();
		Externa1.Interna1 in=ex.new Interna1();

	}

}
