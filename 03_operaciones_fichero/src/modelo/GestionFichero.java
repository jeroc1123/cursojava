package modelo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import excepciones.ErrorEscrituraException;
import excepciones.ErrorLecturaException;

public class GestionFichero {
	private String direccion = "C:\\temp\\datos.txt";

	public GestionFichero(String direccion) {
		this.direccion = direccion;
	}

	public GestionFichero() {
	}

	public void guardarTexto(String cad) throws ErrorEscrituraException { //con el throws propago la excepcion para que la trate la logica de presentacion
		try (FileOutputStream fs = new FileOutputStream(direccion, true); PrintStream out = new PrintStream(fs);) {
			out.println(cad);
			}
		catch (IOException ex) {
			throw new ErrorEscrituraException();
		}
	}

	public List<String> recuperarContenido() throws ErrorLecturaException {
		List<String> lista = new ArrayList<>();
		try (FileReader fr = new FileReader(direccion); BufferedReader bf = new BufferedReader(fr);) {
			String s;
			// te ahorras la lectura previa y lo haces en una sola instruccion
			while ((s = bf.readLine()) != null) {
				lista.add(s);
			}
		}
		catch (IOException ex) {
			throw new ErrorLecturaException();
		}
		return lista;
	}
}