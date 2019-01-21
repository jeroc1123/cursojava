import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Alumno;
import beans.Persona;

public class Pruebas4 {

	public static void main(String[] args) {
		ArrayList<Persona> varias=new ArrayList<>();
		varias.add(new Persona("Alex","al@gg.com",55555,20));				
		varias.add(new Persona("Juan","alfd@gg.es",55555,20));
		varias.add(new Persona("Elena","al@gg.com",42332,17));
		varias.add(new Persona("Marta","alaaoi@gg.com",121,34));
		varias.add(new Persona("Lucas","alert@gg.es",6667,44));
		varias.add(new Persona("Alicia","sdfl@gg.com",2121,35));

		Stream<Persona> st= varias.stream();
		//Nueva lista con las personas mayores de edad
		//List<Persona> resultado = st
		//.filter(p->p.getEdad()>=18)
		//.collect(Collectors.toList());
		//resultado.forEach(p->System.out.println(p.getNombre()));
		
		//Lista de Alumnos donde los que tengan email de dominio .com 
		//se matriculan en Java, y los demas en PHP
		/*List<Alumno> alumnos=
		st
		.map(p-> new Alumno(p.getNombre(),p.getEmail().endsWith(".com")?"Java":"PHP", 0, p.getEdad()))
		.collect(Collectors.toList());
		for (Alumno a:alumnos) {
			System.out.println(a.getNombre() + a.getCurso());
		}*/
		//Igual pero con un array de objetos alumno
		Alumno[] alumnos=
				st
				.map(p-> new Alumno(p.getNombre(),p.getEmail().endsWith(".com")?"Java":"PHP", 0, p.getEdad()))
				.toArray(t->new Alumno[t]);
	}
}