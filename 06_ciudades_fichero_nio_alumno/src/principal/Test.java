package principal;

import java.util.HashSet;

import beans.Ciudad;
import modelo.GestionCiudades;

public class Test {

	public static void main(String[] args) {
		
		GestionCiudades gc=new GestionCiudades();
		gc.altaCiudad(new Ciudad("Avila",15));
		gc.altaCiudad(new Ciudad("Valencia",25));
		System.out.println("Ciudad más calurosa: "+gc.calurosa().getNombre());
		System.out.println("Temperatura media: "+gc.calcularMedia());
		HashSet<Ciudad> todas=gc.getCiudades();
		for(Ciudad c:todas) {
			System.out.println(c.getNombre());
		}
	}

}
