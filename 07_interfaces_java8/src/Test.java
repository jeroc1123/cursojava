interface I1{
	//int k=20;
	static void m() {
		System.out.println("estatico de I1");
	}
}
interface I2 {
	int k=10;
	static void m() {
		System.out.println("estatico de I2");
	}
}

class C1 implements I1,I2{
	
}

public class Test {

	public static void main(String[] args) {
		I2.m();
		I1.m();
		int a=C1.k;
	}

}
