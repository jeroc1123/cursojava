import java.util.Arrays;
import java.util.stream.Collectors;

import beans.Alumno;

public class TestJoining {

	public static void main(String[] args) {
		Alumno[] alumnos= {
				new Alumno("Marcos","Java",6.7,23),
				new Alumno("Victor","PHP",3.8,21),
				new Alumno("Maria","Java",5.9,32),
				new Alumno("Angel","Angular",8,27),
				new Alumno("Manuel","Java",2.8,25),
				new Alumno("Ana","Angular",8.7,20),
				new Alumno("Rebeca","Java",8.0,27)};
		
		System.out.println(Arrays.stream(alumnos)
			.filter(a->a.getCurso().equals("Java"))
			.map(a-> a.getNombre()+",")
			.collect(Collectors.joining())
		);
		//Tambien se puede hacer con reduce aunque genera más basura
//		System.out.println(Arrays.stream(alumnos)
//				.filter(a->a.getCurso().equals("Java"))
//				.map(a-> a.getNombre())
//				.reduce((a,b)->a+","+b)
//				.get()
//			);
	}
}
