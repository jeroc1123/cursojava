package principal;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TestEscritura {

	public static void main(String[] args) {
		String ruta="c:\\temp\\nombres.txt";
		Path pt=Paths.get(ruta);
		List<String> nombres=new ArrayList<>();
		nombres.add("Ángel");nombres.add("Marta");nombres.add("Ana");
		nombres.add("Juan");
		try {
			//escritura en modo append
			Files.write(pt, nombres,StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//escritura de una sola línea
		try(PrintStream out=new PrintStream(Files.newOutputStream(pt, StandardOpenOption.APPEND))){
			out.println("nueva cadena de texto");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
