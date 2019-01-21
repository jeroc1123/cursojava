package principal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import beans.Contacto;
import gestion.GestionContactos;

public class Test {

	static GestionContactos contactos = new GestionContactos();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op;
		do {
			menu();
			op = Integer.parseInt(sc.nextLine());
			switch (op) {
			case 1:
				altaContacto();
				break;
			case 2:
				eliminarContacto();
				break;
			case 3:
				obtenerContactos();
				break;
			}
		} while (op != 4);
	}

	private static void menu() {
		System.out.println("1.- Agregar Contacto: ");
		System.out.println("2.- Eliminar Contacto: ");
		System.out.println("3.- Obtener Contactos: ");
		System.out.println("4.- Salir: ");
	}

	private static void altaContacto() {
		System.out.println("Nombre: ");		
		String nombre = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Edad: ");
		int edad=Integer.parseInt(sc.nextLine());
		Contacto cont = new Contacto(0, nombre, email, edad);
		contactos.alta(cont);
	}
	
	private static void eliminarContacto() {
		System.out.println("Email: ");
		String email = sc.nextLine();
		contactos.eliminar(email);
	}
	private static void obtenerContactos() {
		contactos.recuperar().stream().forEach(p-> System.out.println(p.getNombre()+" "+p.getEmail()+" "+p.getEdad()));
	}
}
