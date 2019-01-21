import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import beans.Alumno;

public class TestAgrupacion {

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
		Map<String,List<Alumno>> datos=Arrays.stream(alumnos)
			.collect(Collectors.groupingBy(p->p.getCurso()));
		
		datos.forEach((k,v)-> { System.out.println("Curso "+k);
								System.out.println("------------------");
							   v.forEach(p->System.out.print(p.getNombre() + " "));
							   System.out.print("\n");});
		}
	}

