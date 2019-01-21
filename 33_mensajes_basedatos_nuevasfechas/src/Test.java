import java.time.LocalDateTime;

import beans.Mensaje;
import gestion.GestionMensajes;

public class Test {

	public static void main(String[] args) {
		Mensaje m=new Mensaje(0,"prueba", 4, LocalDateTime.now());
		GestionMensajes gmensaje=new GestionMensajes();
		gmensaje.altaMensaje(m);
	}
}