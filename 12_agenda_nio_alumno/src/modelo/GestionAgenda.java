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
	Path path;
	public GestionAgenda () {
		path=Paths.get(ruta);
	}

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
		//También se puede hacer con Files.write escribiendo directamente la lista de cadena de caracteres
		//Files.write(path.personas.stream()
		// .map(p-> p.getNombre() + "|" + p.getEmail() + "|" + p.getTelefono())
		// .collect(Collectors.toList()); 	
		if (personas.size() != 0) {
			personas.forEach(p -> resultadoAltas.add(agregar(p)));
		}

		return resultadoAltas.contains(false) ? false : true;
	}

	public List<Persona> recuperarDatosOrdenados() {
		
		try {
			//List<Persona> res= 
					return Files
					.lines(path) 																						//Stream
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2]))) 	//Stream Persona
					.sorted((a,b)->a.getNombre().compareTo(b.getNombre())) 										 		//paso intermedio para ordenar
					.collect(Collectors.toList());																		//List Persona
					//metodo para ordenar con auxilia
					//res.sort((a,b)-> a.getNombre().compareTo(b.getNombre())); 		
					//return res;
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
			// Ahorrandote un paso
			// 		.anyMatch(p -> p.split("[|]")[0].equals(nombre));

			
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Persona buscarPorTelefono(int tel) {
		
		try {
			
			return Files
					.lines(path)
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2]))) 	// Stream Persona
					.filter(p -> p.getTelefono() == tel) 																// Stream Persona
					.findFirst() 						 																// Persona
					.orElse(new Persona("", "", 0)); 																	// Persona
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Persona mayorTelefono() {
		
		try {
			
			return Files
					.lines(path)
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2])))	// Stream Persona
					.max((a, b) -> a.getTelefono() - b.getTelefono()) 													// Persona
					.orElse(new Persona("", "", 0)); 																	// Persona
			
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

	public Persona[] nombresEmailArray(String dom) {
		
		try {

			return Files
					.lines(path)
					.filter(p -> p.split("[|]")[1].endsWith(dom)) 			//Stream String
					.map(p -> new Persona(p.split("[|]")[0], p.split("[|]")[1], Integer.parseInt(p.split("[|]")[2]))) 	//Stream Nombre + email
					.toArray(p -> new Persona[p]);							//Array Nombre + email
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
