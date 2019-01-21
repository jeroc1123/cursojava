package principal;
interface IPrueba{
	void imprimir();
	int value();
}
public class Test_anonimas {

	public static void main(String[] args) {
		int a=5;
		IPrueba ip=new IPrueba() {
			
			@Override
			public int value() {
				//a=12//no podemos usar variables locales
				return 10;
			}
			
			@Override
			public void imprimir() {
				System.out.println("anonima");
				
			}
		};	
		ip.imprimir();
		ip.value();
	}
}
