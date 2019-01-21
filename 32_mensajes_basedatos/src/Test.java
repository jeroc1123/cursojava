import beans.Mensaje;
import modelo.GestionMensajes;

public class Test {

	public static void main(String[] args) {
		Mensaje m=new Mensaje(0, "prueba2", 4, new java.util.Date());
		GestionMensajes gmensajes=new GestionMensajes();
		gmensajes.altaMensaje(m);

	}

}
