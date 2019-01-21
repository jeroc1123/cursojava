package modelo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;

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
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}
	public Ciudad calurosa() {
		Ciudad ciudadMax=new Ciudad("",0);
		try {		
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public HashSet<Ciudad> getCiudades(){
		HashSet<Ciudad> ciudades=new HashSet<>();
		try {
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
