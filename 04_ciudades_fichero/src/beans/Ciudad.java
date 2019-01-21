package beans;

public class Ciudad {
	private String nombre;
	private double temp;
	public Ciudad(String nombre, double temp) {
		super();
		this.nombre = nombre;
		this.temp = temp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ciudad) {
			Ciudad c=(Ciudad)obj;
			if(c.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;		
	}
	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
	
	
	
	
}
