package principal;

import tareas.Ascendente;
import tareas.Descendente;

public class InicioTareas {

	public static void main(String[] args) {
		Ascendente t1=new Ascendente();
		Descendente t2=new Descendente();
		t1.start();
		t2.start();
	}
}