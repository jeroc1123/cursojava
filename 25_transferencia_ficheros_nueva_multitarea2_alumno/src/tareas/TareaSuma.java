package tareas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class TareaSuma implements Callable<Integer> {
	private Path fichero;
	
	public TareaSuma (String fichero) {
		super();
		this.fichero=Paths.get(fichero);
	}
	
	@Override
	public Integer call() {
		try {
			return Files.lines(fichero)
					.mapToInt(p->Integer.parseInt(p))
					.sum();

		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
