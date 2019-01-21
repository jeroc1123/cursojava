package principal;


class Externa2{
	private int b;
	private int a;
	static class Interna2{
		int a;
		public void imprimir() {
			System.out.println("Interna Estandar");
			//b=10;// a la a de la externa no puedes acceder solo variables static
			a=6; //se refiere a la a interna
			//Externa2.this.a =4; // a la a de la externa no puedes acceder
			a =5; // a la de la interna se puede y usar
		}
	}
	public void prueba() {
		Interna2 m=new Interna2();
		m.a=2;
	}
}
	
public class TestEstatica {

	public static void main(String[] args) {
		Externa2.Interna2 obj=new Externa2.Interna2();

	}

}
