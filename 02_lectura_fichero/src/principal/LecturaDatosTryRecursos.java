package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaDatosTryRecursos {
	public static void main(String[] args) {
		String direccion="C:\\temp\\datos.txt";
		//try con recursos. en el try metemos la declaracion de los objetos cerrables.
		//de esta manera se le indica los objetos cerrables, y nos olvidamos de los metodos close
		try (FileReader fr=new FileReader(direccion); BufferedReader bf=new BufferedReader(fr);){
			String s;
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
	}
}