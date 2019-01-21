import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Alumno;
import beans.Persona;

public class Pruebas5 {

	public static void main(String[] args) {
		ArrayList<Persona> varias=new ArrayList<>();
		varias.add(new Persona("Alex","al@gg.com",55555,20));				
		varias.add(new Persona("Juan","alfd@gg.es",55555,20));
		varias.add(new Persona("Elena","al@gg.com",42332,17));
		varias.add(new Persona("Marta","alaaoi@gg.com",121,34));
		varias.add(new Persona("Lucas","alert@gg.es",6667,44));
		varias.add(new Persona("Alicia","sdfl@gg.com",2121,35));

		Stream<Persona> st= varias.stream();
		//Igual pero con un HashMap de objetos alumno
		Map<String, Alumno> alumnos=
				st    //Stream<Persona>
				.collect(Collectors.toMap(p->p.getEmail(), p->new Alumno(p.getNombre(),p.getEmail().endsWith(".com")?"Java":"PHP",0,p.getEdad())));
//				
//				st
//				.filter(p->p.getEdad()>=18)
//				.map(p-> new Alumno(p.getNombre(),p.getEmail().endsWith(".com")?"Java":"PHP", 0, p.getEdad()))
//				.forEach(i->alumnos.put(i.getNombre(), i));
		//Otra manera

		
		
				alumnos.forEach((a,b)-> System.out.println(b.getNombre()+" "+b.getEdad()));
	}
}