package principal;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Escritura {
	//escritura en modo reemplazo
	public static void main(String[] args) {
		String direccion="c:\\temp\\datos.txt";

		try {
			PrintStream salida=new PrintStream(direccion);
			salida.println("lunes");
			salida.println("martes");
			salida.println("miercoles");
			System.out.println("Se ha escrito en el fichero");
		}

		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
