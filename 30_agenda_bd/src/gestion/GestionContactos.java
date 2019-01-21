package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Contacto;

public class GestionContactos {
	private final static String cadena="jdbc:mysql://localhost:3306/agenda";
	private final static String user="root";
	private final static String pwd="root";
	
	public boolean alta(Contacto contacto) {
		//1 Establecer conexion en el try con recursos
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="insert into contactos (nombre, email, edad) ";
			sql+="values ('"+contacto.getNombre() +"','"+contacto.getEmail()+"',"+contacto.getEdad() +")";	
			//2 Lanzamiento de instruccion sql
			Statement st=con.createStatement();
			st.execute(sql);
			//4 cierre de conexion en el try con recursos
			System.out.println("Contacto Añadido");
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean alta(Contacto[] contactos) {
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			con.setAutoCommit(false);
			
			String sql="insert into contactos (nombre, email, edad) values (?,?,?)";	
			PreparedStatement st=con.prepareStatement(sql);
			
			for (Contacto c:contactos) {
				st.setString(1, c.getNombre());
				st.setString(2, c.getEmail());
				st.setInt(3, c.getEdad());
				st.execute();	
			}
			con.commit();
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public void eliminar(String email) {
		//1 Establecer conexion en el try con recursos
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="delete from contactos where email = '"+email+"'";
			//2 Lanzamiento de instruccion sql
			Statement st=con.createStatement();
			st.execute(sql);
			//4 cierre de conexion en el try con recursos
			System.out.println("Contacto Eliminado");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public List<Contacto> recuperar() {
		List<Contacto> listado=new ArrayList<>();
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="select * from contactos";	
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				listado.add(new Contacto(
							rs.getInt("idContacto"),
							rs.getString("nombre"),
							rs.getString("email"),
							rs.getInt("edad")
							));
			}
			return listado;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public boolean existe (String nombre) {
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="select * from contactos";	
			sql+=" where nombre = '"+nombre+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			return rs.next();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public void modificarEmail(String nombre, String email) {
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="update contactos";
			sql+=" set email ='"+email+"'";
			sql+=" where nombre = '"+nombre+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public double mediaEdad() {
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="select avg(edad) from contactos";	
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
				return rs.getDouble(1);
			}
			else 
			{
				return 0.0;
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}
}
