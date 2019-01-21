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
		
		Stream<Persona> st= varias.stream();
		/*	mostramos los nombres de las personas mayores de 30*/
		st
		.filter(p->p.getEdad()>20)
		.forEach(p-> System.out.println(p.getNombre()));
		//*/
		
		/*	muestra los nombres de todas las personas y despues
			indica cuantas personas hay
			esto falla por que en la primera operacion se ha consumido
		long total=st.count();
		st.forEach(p->System.out.println(p.getNombre()));
		System.out.print("Hay"+total+" Total");*/
//		long total=st
//				//por si solo peek no hace nada
//					.peek(p->System.out.println(p.getNombre()))
//					.count();
//		System.out.print("Hay "+total+" en Total");
		//suma de todas las edades
		//System.out.print("El total de edades es " + st.mapToInt(p->p.getEdad()).average().getAsDouble());
	}
}