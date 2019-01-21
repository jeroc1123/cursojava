

import java.util.Arrays;

import beans.Alumno;

public class Pruebas3 {

	public static void main(String[] args) {
		Alumno[] alumnos = {new Alumno("Marcos", "Java", 6.7, 23), 
							new Alumno("Victor", "PHP", 3.8, 21),
							new Alumno("Maria", "Java", 5.9, 32), 
							new Alumno("Angel", "Angular", 8, 27),
							new Alumno("Manuel", "Java", 2.8, 27), 
							new Alumno("Ana", "Angular", 8.7, 23),
							new Alumno("Rebeca", "Java", 8.0, 23) };
		// No es necesario importar Stream, ya que no usamos el objeto Stream
		/*System.out.println(Arrays.stream(alumnos)
				.filter(p -> p.getCurso()
				.equalsIgnoreCase("Java"))
				.mapToDouble(p -> p.getNota())
				.average()
				.getAsDouble());*/
		//Algun suspenso en Angular 
		//Solucion 1
		/*Arrays.stream(alumnos)
		.filter(p->p.getCurso().equals("Angular"))
		.anyMatch(p->p.getNota()<5);
		//Solucion 2
		Arrays.stream(alumnos)
		.filter(p->p.getCurso().equals("Angular")&&p.getNota()<5)
		.count();*/
		//Los métodos Match funciona en modo cortocircuito
		/*System.out.println(
		Arrays.stream(alumnos)
		.filter(p->p.getEdad()>20)
		.peek(p->System.out.println(p.getNombre()))
		.anyMatch(p->p.getCurso().equals("PHP")));*/
		//Mostrar el nombre del alumno con la nota mas alta
		//System.out.println(
		//		Arrays.stream(alumnos)
		//		.max((a,b)-> a.getNota() - b.getNota() > 0 ? 1:-1)
		//		.get()
		//		.getNombre());
		//Nombre de la primera persona que esté aprobada en el curso de java
		//Si no hay ninguno que ponga no hay ninguno sin usar ni if ni operador ternario
		System.out.println(Arrays.stream(alumnos)
			.filter(p->p.getCurso().equals("PHP")&&p.getNota()>=5)
			.findFirst()
			.orElse(new Alumno("No existe alumno","",0,0))
			.getNombre());
		
	}
}
