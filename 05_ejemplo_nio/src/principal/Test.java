package principal;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		String ruta="c:\\temp\\datos.txt";
		Path pt=Paths.get(ruta);
		try {
			Files.readAllLines(pt,Charset.forName("ISO-8859-1")).forEach(s->System.out.println(s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
