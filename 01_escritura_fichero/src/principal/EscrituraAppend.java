package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EscrituraAppend {
	//escritura en modo append
	public static void main(String[] args) {
		String direccion="c:\\temp\\datos.txt";
		FileOutputStream fs=null;
		PrintStream salida=null;
		try {
			//creamos FileOutputStream
			fs=new FileOutputStream(direccion, true);
			//creamos el PrintStream a partir del FileOutputStream
			salida=new PrintStream(fs);
			salida.println("jueves");
			salida.println("viernes");
			System.out.println("Se ha añadido en el fichero");

		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} //Superclase de FileNotFoundException. 
		//Superclase de todas las excepciones de E/S
		finally {
			if (salida!=null) {
				salida.close();
			}
			try {
				if (fs!=null) {
					fs.close();
				}
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
