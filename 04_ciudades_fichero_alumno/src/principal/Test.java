package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import beans.Ciudad;
import modelo.GestionCiudades;

public class Test {

	static GestionCiudades ciu=new GestionCiudades();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		int op;
		do {
			menu();
			op=Integer.parseInt(sc.nextLine());
			switch(op) {
				case 1:
					agregarCiudad();
					break;
				case 2:
					calcularMedia();
					break;
				case 3:
					calcularMaxima();
					break;
				case 4:
					listaCiudades();
			}
		}while(op!=5);
	}
	private static void menu() {
		System.out.println("1.- Agregar Ciudad: ");
		System.out.println("2.- Temperatura Media: ");
		System.out.println("3.- Ciudad mas Calurosa: ");
		System.out.println("4.- Mostrar todas: ");
		System.out.println("5.- Salir: ");
	}
	private static void agregarCiudad() {
		//Scanner sc=new Scanner(System.in);
		String nombre;
		System.out.println("Dame una ciudad: ");
		nombre=sc.nextLine();
		System.out.println("Dame temperatura: ");
		double temp=Double.parseDouble(sc.nextLine());
		//creamos objeto con sus datos
		Ciudad c=new Ciudad(nombre,temp);		
		try {
			ciu.altaCiudad(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	private static void calcularMedia() {
		try {
			System.out.println("La temperatura media es "+ciu.calcularMedia());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void calcularMaxima() {
		Ciudad c;
		try {
			c = ciu.calurosa();
			System.out.println("La ciudad mas calurosa es "+c.getNombre()+" - "+c.getTemp());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		private static void listaCiudades() {
			try {
				ciu.getCiudades().forEach(s->System.out.println(s.getNombre()+" - "+s.getTemp()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
