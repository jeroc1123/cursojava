package tareas;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Fichero extends Thread {
	private String ruta ="numeros.txt";
	private Path path=Paths.get(ruta);
	private int numero=0;
	private Path fichSal;
	@Override
	public void run() {	 
		try (PrintStream out = new PrintStream(Files.newOutputStream(fichSal, StandardOpenOption.CREATE,StandardOpenOption.APPEND));) {
			Files.lines(path)
			.filter(p->Integer.parseInt(p)<numero)
			.forEach(p->out.println(p));
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Fichero(int numero, String fichSal){
		super();
		this.numero=numero;
		this.fichSal=Paths.get(fichSal);
	}
	
}
