import java.util.Arrays;

import beans.Alumno;

public class Pruebas3 {

	public static void main(String[] args) {
		Alumno[] alumnos= {
				new Alumno("Marcos","Java",6.7,23),
				new Alumno("Victor","PHP",3.8,21),
				new Alumno("Maria","Java",5.9,32),
				new Alumno("Angel","Angular",8,27),
				new Alumno("Manuel","Java",2.8,25),
				new Alumno("Ana","Angular",8.7,20),
				new Alumno("Rebeca","Java",8.0,27)
		};

		/*System.out.println(Arrays.stream(alumnos)
			.filter(p->p.getCurso().equals("Java"))
			.mapToDouble(p->p.getNota())
			.average()
			.getAsDouble());*/
		/*
		//¿algún suspenso en Angular?
		//solución 1:
		Arrays.stream(alumnos)
		.filter(p->p.getCurso().equals("Angular"))
		.anyMatch(p->p.getNota()<5);
		//solución 2
		Arrays.stream(alumnos)
		.filter(p->p.getCurso().equals("Angular")&&p.getNota()<5)
		.count();
		*/
		//los métodos match funcionan en modo cortocircuito
		//solo muestra los dos primeros
		/*System.out.println(
			Arrays.stream(alumnos)
			.peek(p->System.out.println(p.getNombre()))
			.anyMatch(p->p.getCurso().equals("PHP"))
		);*/
		
		//mostrar el nombre del alumno con la nota más alta
		/*System.out.println(Arrays.stream(alumnos)   //stream
		.max((a,b)->(a.getNota()-b.getNota())>0?1:-1)  //Optional
		.get()											//Alumno
		.getNombre());	//String*/
		
		//nombre del primer alumno aprobado de Java, sino mensaje indicativo
		
		System.out.println(Arrays.stream(alumnos)  //stream
		.filter(a->a.getNota()>=5 && a.getCurso().equals("PHP")) //stream
		.findFirst() //Optional
		.orElse(new Alumno("No existe","PHP",0,0)) //Alumno
		.getNombre());//String
		
		
	}

}
