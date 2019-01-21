package principal;

import java.time.Period;

public class TestPeriodoDuracion {

	public static void main(String[] args) {
		Period p1=Period.of(2, 0, 100);
		Period p2=Period.ofDays(5);
		System.out.println(p1);
		System.out.println(p2);
	}
}