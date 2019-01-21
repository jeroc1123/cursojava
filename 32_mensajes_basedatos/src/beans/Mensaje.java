package beans;

import java.util.Date;

public class Mensaje {
	private int idMensaje;
	private String texto;
	private int idContacto;
	private Date fecha;
	public Mensaje(int idMensaje, String texto, int idContacto, Date fecha) {
		super();
		this.idMensaje = idMensaje;
		this.texto = texto;
		this.idContacto = idContacto;
		this.fecha = fecha;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
