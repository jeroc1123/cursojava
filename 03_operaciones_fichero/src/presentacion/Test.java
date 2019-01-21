package presentacion;

import excepciones.ErrorEscrituraException;
import excepciones.ErrorLecturaException;
import modelo.GestionFichero;

public class Test {

	public static void main(String[] args) {
		GestionFichero gfichero=new GestionFichero();
			try {
				gfichero.guardarTexto("prueba1");
				gfichero.guardarTexto("prueba2");
				gfichero.recuperarContenido().forEach(s->System.out.println(s));
			} catch (ErrorEscrituraException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (ErrorLecturaException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
	}
}
