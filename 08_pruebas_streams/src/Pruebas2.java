import java.util.ArrayList;
import java.util.stream.Stream;

import beans.Persona;

public class Pruebas2 {

	public static void main(String[] args) {
		ArrayList<Persona> varias=new ArrayList<>();
		varias.add(new Persona("Alex","al@gg.com",55555,20));				
		varias.add(new Persona("Juan","alfd@gg.com",55555,20));
		varias.add(new Persona("Elena","al@gg.com",42332,17));
		varias.add(new Persona("Marta","alaaoi@gg.com",121,34));
		varias.add(new Persona("Lucas","alert@gg.com",6667,44));
		varias.add(new Persona("Alicia","sdfl@gg.com",2121,35));
		Stream<Persona> st=varias.stream();
		/*mostramos los nombres de las personas mayores de 30
		st
		.filter(p->p.getEdad()>20)
		.forEach(p->System.out.println(p.getNombre()));
		*/
		
		//muestra los nombres de todas las personas y después indica cuantas personas hay
		
		/*error de ejecución, el stream se consume en la primera llamada a método
		long total=st.count();
		st.forEach(p->System.out.println(p.getNombre()));
		System.out.print("Hay "+total);
		*/
		/*long total=st.peek(p->System.out.println(p.getNombre())).count();
		System.out.print("Hay "+total);*/
		//esto no mostraría nada
		//st.peek(p->System.out.println(p.getNombre()));
		
		//suma de todas edades
		System.out.println(st.mapToInt(p->p.getEdad()).sum());

	}

}
