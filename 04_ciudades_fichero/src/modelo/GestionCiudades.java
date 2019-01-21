package modelo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;

import beans.Ciudad;


public class GestionCiudades {
	String ruta="ciudades.txt";
	
	
	public boolean altaCiudad(Ciudad cd) {
		try(FileOutputStream fs=new FileOutputStream(ruta,true);
				PrintStream out=new PrintStream(fs);){
				out.println(cd.getNombre()+"|"+cd.getTemp());
				return true;
			}
			catch(IOException ex) {
				ex.printStackTrace();
				return false;
			}
		
		
	}
	public double calcularMedia() {
		double media=0;
		int cont=0;
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);) {		
				String s;
				while((s=bf.readLine())!=null) {
					media+=Double.parseDouble(s.split("[|]")[1]);
					cont++;
				}
				return media/cont;
			}
			catch(IOException ex) {
				ex.printStackTrace();
				return 0;
			}
		
	}
	public Ciudad calurosa() {
		Ciudad ciudadMax=new Ciudad("",0);
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);) {		
				String s;
				while((s=bf.readLine())!=null) {
					String[] datos=s.split("[|]");
					if(Double.parseDouble(datos[1])>ciudadMax.getTemp()) {
						ciudadMax.setNombre(datos[0]);
						ciudadMax.setTemp(Double.parseDouble(datos[1]));
					}
				}
				return ciudadMax;
			}
			catch(IOException ex) {
				ex.printStackTrace();
				return null;
			}
		
	}
	
	public HashSet<Ciudad> getCiudades(){
		HashSet<Ciudad> ciudades=new HashSet<>();
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);) {		
				String s;
				while((s=bf.readLine())!=null) {
					String[] datos=s.split("[|]");
					ciudades.add(new Ciudad(datos[0],Double.parseDouble(datos[1])));
				}
				return ciudades;
			}
			catch(IOException ex) {
				ex.printStackTrace();
				return null;
			}
	}
}
