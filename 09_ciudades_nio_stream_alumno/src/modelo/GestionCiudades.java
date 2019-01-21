package modelo;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import beans.Ciudad;


public class GestionCiudades {
	String ruta="ciudades.txt";
	Path path;
	double media=0;
	int cont=0;
	
	
	public GestionCiudades() {
		path=Paths.get(ruta);
	}
	
	public boolean altaCiudad(Ciudad cd) {
		try(PrintStream out=new PrintStream(Files.newOutputStream(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND));){
				out.println(cd.getNombre()+"|"+cd.getTemp());
				return true;
			}
			catch(IOException ex) {
				ex.printStackTrace();
				return false;
			}
	}
	public double calcularMedia() {

		try {	
			return Files
					.lines(path)
					.mapToDouble(p->Double.parseDouble(p.split("[|]")[1]))
					.average()
					.orElse(0);
			}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}
	public Ciudad calurosa() {
		
		try {		
			return Files
					.lines(path)
					.map(p -> new Ciudad(p.split("[|]")[0], Double.parseDouble(p.split("[|]")[1])))
					.max((a,b) -> a.getTemp() - b.getTemp()> 0 ? 1: -1)
					.orElse(new Ciudad("",0))
					;		
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}	
	}
	
	public HashSet<Ciudad> getCiudades(){
		try {
			//HashSet<Ciudad> ciudades=new HashSet(Files
				//	.lines(path)
					//.map(p -> new Ciudad(p.split("[|]")[0], Double.parseDouble(p.split("[|]")[1])))
					//.collect(Collectors.toSet()));
			return (new HashSet(Files
					.lines(path)
					.map(p -> new Ciudad(p.split("[|]")[0], Double.parseDouble(p.split("[|]")[1])))
					.collect(Collectors.toSet())));
			//return ciudades;
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean existeCiudad (String nombre) {
		try {
			return Files
					.lines(path)
					.map(p -> p.split("[|]")[0])
					.anyMatch(p-> p.equals(nombre))
					;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
