package principal;

import java.util.ArrayList;
import beans.Persona;
import modelo.GestionAgenda;

public class Test {

	public static void main(String[] args) {
		GestionAgenda ga=new GestionAgenda();
		ArrayList<Persona> pers=new ArrayList<Persona>();
		pers.add(new Persona("Antonio","antonio@google.com",609111111));
		pers.add(new Persona("Manuel","manuel@manuel.org",609222222));
		pers.add(new Persona("Sara","sara@sara.es",609333333));
		pers.add(new Persona("Martina","martina@google.com",609888888));
		pers.add(new Persona("Santiago","santi@yahoo.com",609444444));
		pers.add(new Persona("Alejandra","alex@protonmail.com",609844444));
		//Alta masiva
		System.out.println("Alta masiva " + ga.agregarVarias(pers));
		//Recuperar Agenda
		for(Persona p:ga.recuperarDatosOrdenados()) {
			System.out.println(p.getNombre()+" "+p.getEmail()+" "+p.getTelefono());
		}
		//Obtener la persona con el numero más alto
		System.out.println("Mayor Telefono: " + ga.mayorTelefono());
		//Buscar por telefono no encontrado
		System.out.println("Persona con numero 2222222"+ga.buscarPorTelefono(2222222));
		//Buscar por telefono existente
		System.out.println("Persona con numero "+ga.mayorTelefono().getTelefono()+" "+ga.buscarPorTelefono(ga.mayorTelefono().getTelefono()));
		//Busqueda por email Lista
		for (String p:ga.nombresEmail(".com")) {
			System.out.println(p);
		}
		//Busqueda por email Array
		for (String p:ga.nombresEmailArray(".org")){
			System.out.println(p);
		}
	}
}