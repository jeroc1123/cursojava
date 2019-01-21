package modelo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;

import beans.Ciudad;

public class GestionCiudades {
	String ruta = "ciudades.txt";
	Path pt = Paths.get(ruta);
	int cont = 0;
	double media = 0;

	public boolean altaCiudad(Ciudad cd) {
		// try(FileOutputStream fs=new FileOutputStream(ruta,true);
		try (PrintStream out = new PrintStream(
				Files.newOutputStream(pt, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
			out.println(cd.getNombre() + "|" + cd.getTemp());
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public double calcularMedia() {
		try {
			Files.readAllLines(pt, Charset.forName("ISO-8859-1")).forEach(s -> {
				media += Double.parseDouble(s.split("[|]")[1]);
				cont++;
			});
			return media / cont;
		} catch (IOException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public Ciudad calurosa() {
		Ciudad ciudadMax = new Ciudad("", 0);

		try {
			Files.readAllLines(pt, Charset.forName("ISO-8859-1")).forEach(p -> {
				String[] datos = p.split("[|]");
				if (Double.parseDouble(datos[1]) > ciudadMax.getTemp()) {
					ciudadMax.setNombre(datos[0]);
					ciudadMax.setTemp(Double.parseDouble(datos[1]));
				}
			});
			return ciudadMax;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public HashSet<Ciudad> getCiudades() {
		HashSet<Ciudad> ciudades = new HashSet<>();
		try {
			Files.readAllLines(pt, Charset.forName("ISO-8859-1")).forEach(p -> {
				String[] datos = p.split("[|]");
				ciudades.add(new Ciudad(datos[0], Double.parseDouble(datos[1])));
			});
			return ciudades;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
