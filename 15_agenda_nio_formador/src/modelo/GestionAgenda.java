package modelo;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import beans.Persona;

public class GestionAgenda {
	// final String ruta = "c:\\temp\\agenda.dat";
	final String ruta = "agenda.dat";
	Path path = Paths.get(ruta);
	int exitos = 0;

	public boolean agregar(Persona p) {
		
		try (PrintStream out = new PrintStream(
				Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND));) {
			
			boolean salida = false;

			if (!existe(p.getNombre())) {
				out.println(p.getNombre() + "|" + p.getEmail() + "|" + p.getTelefono());
				salida = true;
			}

			return salida;

		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean agregarVarias(List<Persona> personas) {
		
		ArrayList<Boolean> resultadoAltas = new ArrayList<>();

		if (personas.size() != 0) {
			personas.forEach(p -> resultadoAltas.add(agregar(p)));
		}

		return resultadoAltas.contains(false) ? false : true;
	}

	public List<Persona> recuperarDatosOrdenados() {
		
		try {
			return Files
					.lines(path) //Stream
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2]))) //Stream Persona
					.collect(Collectors.toList()); //List Persona
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean existe(String nombre) {
		
		try {
			
			return Files
					.lines(path) 						//Stream 
					.map(p -> p.split("[|]")[0]) 		//Stream nombres
					.anyMatch(p -> p.equals(nombre)); 	//Boolean resultado busqueda
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Persona buscarPorTelefono(int tel) {
		
		try {
			
			return Files
					.lines(path)
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2]))) // Stream Persona
					.filter(p -> p.getTelefono() == tel) 	// Stream Persona
					.findFirst() 						 	// Persona
					.orElse(new Persona("", "", 0)); 		// Persona
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Persona mayorTelefono() {
		
		try {
			
			return Files
					.lines(path)
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2]))) // Stream Persona
					.max((a, b) -> a.getTelefono() - b.getTelefono()) 	// Persona
					.orElse(new Persona("", "", 0)); 					// Persona
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<String> nombresEmail(String dom) {
		
		try {
			
			return Files
					.lines(path)
					.filter(p -> p.split("[|]")[1].endsWith(dom)) 			//Stream String
					.map(p -> p.split("[|]")[0] + " " + p.split("[|]")[1]) 	//Stream Nombre + email
					.collect(Collectors.toList()); 							//List Nombre + email
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String[] nombresEmailArray(String dom) {
		
		try {

			return Files
					.lines(path)
					.filter(p -> p.split("[|]")[1].endsWith(dom)) 			//Stream String
					.map(p -> p.split("[|]")[0] + " " + p.split("[|]")[1]) 	//Stream Nombre + email
					.toArray(p -> new String[p]);							//Array Nombre + email
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
