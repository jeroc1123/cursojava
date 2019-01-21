package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercionContactos {
	private final static String cadena="jdbc:mysql://localhost:3306/agenda";
	private final static String user="root";
	private final static String pwd="root";
	
	public static void main(String[] args) {
		//1 Establecer conexion en el try con recursos
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="insert into contactos (nombre, email, edad)";
			sql += "values ('contacto3','contacto3@gmail.com',31)";	
			//2 Lanzamiento de instruccion sql
			Statement st=con.createStatement();
			st.execute(sql);
			//4 cierre de conexion en el try con recursos
			System.out.println("Contacto Añadido");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
