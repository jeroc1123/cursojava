package excepciones;

public class ErrorLecturaException extends Exception {
	public ErrorLecturaException() {
		super("no se ha podido leer el contenido");
	}

}
