package modelo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import beans.Ciudad;

public class GestionCiudades {
	private String direccion="c:\\temp\\ciudades.txt";
	//private String direccion = "/Volumes/HD Datos/jesusmrodriguezcerezo/Desktop/ciudades.txt";

	public GestionCiudades() {
	}
	//*********************************************************************** 
	//hay que meter try con recursos para que se ocupe de cerrar los ficheros
	//***********************************************************************
	public boolean altaCiudad(Ciudad cd) throws IOException {
		if (!comprobarRepetido(cd)) {
			FileOutputStream fs = new FileOutputStream(direccion, true);
			PrintStream out = new PrintStream(fs);
			out.println(cd.getNombre() + "|" + cd.getTemp());
			return true;
		} else {
			return false;
		}
	}

	public double calcularMedia() throws IOException {
		FileReader fr = new FileReader(direccion);
		BufferedReader bf = new BufferedReader(fr);
		double media = 0;
		double contador = 0;
		String s = null;
		while ((s = bf.readLine()) != null) {
			//Se puede usar directamente el array sin pasar por una variable auxiliar S2
			media += Double.parseDouble(s.split("\\|")[1]);
			//String[] s2 = s.split("\\|");
			//media += Double.parseDouble(s2[1]);
			contador++;
		}
		if (contador == 0) {
			return 0;
		} else {
			return media / contador;
		}
	}

	public Ciudad calurosa() throws IOException {
		FileReader fr = new FileReader(direccion);
		BufferedReader bf = new BufferedReader(fr);
		Ciudad ciudadMax = new Ciudad("", 0);
		String s = null;
		while ((s = bf.readLine()) != null) {
			String[] s2 = s.split("\\|");
			if (ciudadMax.getTemp() < Double.parseDouble(s2[1])) {
				ciudadMax.setNombre(s2[0]);
				ciudadMax.setTemp(Double.parseDouble(s2[1]));
			}
		}
		return ciudadMax;
	}

	public List<Ciudad> getCiudades() throws IOException {
		FileReader fr = new FileReader(direccion);
		BufferedReader bf = new BufferedReader(fr);
		List<Ciudad> lista = new ArrayList<>();
		String s = null;
		while ((s = bf.readLine()) != null) {
//			Ciudad cd = new Ciudad();
			String[] s2 = s.split("\\|");
//			cd.setNombre(s2[0]);
//			cd.setTemp(Double.parseDouble(s2[1]));
//			lista.add(cd);
			//se puede reemplazar por 
			lista.add(new Ciudad(s2[0],Double.parseDouble(s2[1])));
		}
		return lista;
	}

	public boolean comprobarRepetido(Ciudad cd) throws IOException {
		FileReader fr = new FileReader(direccion);
		BufferedReader bf = new BufferedReader(fr);
		String s = null;
		boolean aux = false;
		while ((s = bf.readLine()) != null) {
			//Se puede escapar mediante [] en vez de \\ 
			//String[] s2 = s.split("\\|");
			//Se puede reemplazar incluyendo el split en el if
			if (cd.getNombre().equalsIgnoreCase(s.split("\\|")[0])) {
				aux = true;
				break;
			}
		}
		return aux;
	}
}
