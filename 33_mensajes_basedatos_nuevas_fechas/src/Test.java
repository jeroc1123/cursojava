import java.time.LocalDateTime;

import beans.Mensaje;
import modelo.GestionMensajes;

public class Test {

	public static void main(String[] args) {
		Mensaje m=new Mensaje(0, "prueba2", 4, LocalDateTime.now());
		GestionMensajes gmensajes=new GestionMensajes();
		gmensajes.altaMensaje(m);

	}

}
