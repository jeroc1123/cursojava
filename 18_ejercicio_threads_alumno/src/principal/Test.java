package principal;

import java.util.Scanner;

import tareas.Fichero;

public class Test {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int numero;
		do {
			System.out.println("Introduzca Numero. 0 para salir ");
			numero = Integer.parseInt(sc.nextLine());
			String fichSal="ficheroSalida"+numero+".txt";
			Fichero f=new Fichero(numero,fichSal);
			f.start();
			
		} while (numero!=0);
	}
}
