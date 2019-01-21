package principal;

//implementa el patron singleton
class MiSingleton{
	
	private static MiSingleton obj;
	static {
		obj=new MiSingleton();
	}
	
	private MiSingleton() {
		
	}
	
	public static MiSingleton getInstance() {
		return obj;
	}
}

public class Test {

	public static void main(String[] args) {
		// apunta al mismo objeto de la misma clase
		MiSingleton a = MiSingleton.getInstance();
		MiSingleton b = MiSingleton.getInstance();
	}
}