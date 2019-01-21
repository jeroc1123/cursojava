package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TestNuevasFechas {

	public static void main(String[] args) {
		LocalDate ld=LocalDate.now().of(2015, 10, 15);
		//ld=ld.plusDays(22);
		LocalTime lt=LocalTime.of(20,3,10,123565655);
		lt=lt.plusHours(30);
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
	
		// otro ejemplo para sumar cualquier unidad de tiempo
		// para localDate sólo fechas, para localTime horas min segundos
		//ld=ld.plus(5,ChronoUnit.DAYS);
		//La siguiente operacion da error de ejecucion, ya que estamos sumando horas a una fecha.
		//ld=ld.plus(5,ChronoUnit.HOURS);
	}
}