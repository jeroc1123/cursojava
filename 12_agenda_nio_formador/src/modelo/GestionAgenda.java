package modelo;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import beans.Persona;

public class GestionAgenda {
	final String ruta="c:\\temp\\agenda.dat";
	Path path;
	public GestionAgenda() {
		path=Paths.get(ruta);
	}
	public boolean agregar(Persona p) {
		try(PrintStream out=new PrintStream(Files.newOutputStream(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND));){
			out.println(p.getNombre()+"|"+p.getEmail()+"|"+p.getTelefono());
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean agregarVarias(List<Persona> personas){
		try {
			//transformamos List<Persona> en List<String> para poder llamar al método write
			Files.write(path, personas.stream()
					.map(p->p.getNombre()+"|"+p.getEmail()+"|"+p.getTelefono())
					.collect(Collectors.toList())
					);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	public List<Persona> recuperarDatosOrdenados() {
		/*try {
			List<Persona> res= Files.lines(path)
					.map(s->new Persona(s.split("[|]")[0],
										s.split("[|]")[1],
										Integer.parseInt(s.split("[|]")[2])))
					.collect(Collectors.toList());
			
					res.sort((p1,p2)->p1.getNombre().compareTo(p2.getNombre()));
					return res;
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}*/
		
		//opción 2:
		try {
			return Files.lines(path)
					.map(s->new Persona(s.split("[|]")[0],
										s.split("[|]")[1],
										Integer.parseInt(s.split("[|]")[2])))
					.sorted((p1,p2)->p1.getNombre().compareTo(p2.getNombre()))
					.collect(Collectors.toList());
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	public boolean existe(String nombre) {
		try {
			return Files.lines(path).anyMatch(s->s.split("[|]")[0].equals(nombre));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Persona buscarPorTelefono(int tel) {
		try {
			return Files.lines(path)
					.map(s->new Persona(s.split("[|]")[0],
										s.split("[|]")[1],
										Integer.parseInt(s.split("[|]")[2])))
					.filter(p->p.getTelefono()==tel)
					.findFirst()
					.orElse(null);
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Persona mayorTelefono() {
		try {
			return Files.lines(path)
					.map(s->new Persona(s.split("[|]")[0],
										s.split("[|]")[1],
										Integer.parseInt(s.split("[|]")[2])))
					.max((p1,p2)->p1.getTelefono()-p2.getTelefono())
					.orElse(null);
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> nombresEmail(String dom) {
		try {
			return Files.lines(path)
					.filter(s->s.split("[|]")[1].endsWith(dom))
					.map(s->s.split("[|]")[0])
					.collect(Collectors.toList());
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	public Persona[] nombresEmailArray(String dom) {
		try {
			return Files.lines(path)
					.filter(s->s.split("[|]")[1].endsWith(dom))
					.map(s->new Persona(s.split("[|]")[0],
							s.split("[|]")[1],
							Integer.parseInt(s.split("[|]")[2])))
					.toArray(t->new Persona[t]);
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}
