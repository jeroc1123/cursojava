package principal;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDate {

	public static void main(String[] args) {
		Date dt1=new Date();
		Date dt2=new Date(-1555515555555L);
		Date dt3=new Date(145486532332L);
		
		System.out.println(dt1);
		System.out.println(dt2);
		System.out.println(dt3);
		
		Calendar c=Calendar.getInstance();
		System.out.println("Año " +c.get(Calendar.YEAR));
		System.out.println("Mes " +(c.get(Calendar.MONTH)+1));
		System.out.println("Dia " +c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hora " +c.get(Calendar.HOUR));
		
		Calendar c2=Calendar.getInstance();
		c2.setTime(dt3);
		System.out.println("Año " +c2.get(Calendar.YEAR));
		System.out.println("Mes " +(c2.get(Calendar.MONTH)+1));
		System.out.println("Dia " +c2.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hora " +c2.get(Calendar.HOUR));
		
		//Formateado
		DateFormat df1=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, new Locale("ES"));
		DateFormat df2=DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("US"));
		System.out.println(df1.format(dt1));
		System.out.println(df2.format(dt1));
	}

}
