package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaDatos {
	public static void main(String[] args) {
		String direccion="C:\\temp\\datos.txt";
		FileReader fr=null;
		BufferedReader bf=null;
		try {
			//creamos el objeto FileReader para apuntar el fichero
			fr=new FileReader(direccion);
			//se crea el objeto BufferReader
			bf=new BufferedReader(fr);
			String s;
			//System.out.println(bf.readLine());		
			//te ahorras la lectura previa lo haces en una sola instruccion
			while ((s=bf.readLine())!=null) {
				System.out.println(s);
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (bf!=null) bf.close();
				if (fr!=null) fr.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}