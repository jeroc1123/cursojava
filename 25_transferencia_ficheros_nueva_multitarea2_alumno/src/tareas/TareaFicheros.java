package tareas;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class TareaFicheros implements Runnable {
	private Path rutaOrigen;
	private Path rutaDestino;
	private int numeroComprobar;
	public TareaFicheros(String rutaOrigen, String rutaDestino, int numeroComprobar) {
		super();
		this.rutaOrigen = Paths.get(rutaOrigen);
		this.rutaDestino = Paths.get(rutaDestino);
		this.numeroComprobar = numeroComprobar;
	}
	
	public void run() {
		
		try {
			Files.write(rutaDestino, Files.lines(rutaOrigen)
					.filter(s->Integer.parseInt(s)<numeroComprobar)
					.collect(Collectors.toList()),StandardOpenOption.CREATE,StandardOpenOption.APPEND
					);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			
		}
	}
	
}
