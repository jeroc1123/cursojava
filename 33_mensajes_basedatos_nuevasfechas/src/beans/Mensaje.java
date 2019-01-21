package beans;

import java.time.LocalDateTime;
import java.util.Date;

public class Mensaje {
	private int idMensaje;
	private String texto;
	private int idContacto;
	private LocalDateTime fecha;
	
	public Mensaje(int idMensaje, String texto, int idContacto, LocalDateTime fecha) {
		this.idMensaje=idMensaje;
		this.texto=texto;
		this.idContacto=idContacto;
		this.fecha=fecha;
	}
	
	public int getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
