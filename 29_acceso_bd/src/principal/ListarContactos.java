package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarContactos {

	private final static String cadena="jdbc:mysql://localhost:3306/agenda";
	private final static String user="root";
	private final static String pwd="root";
	
	public static void main(String[] args) {
//		//1 Establecer conexion en el try con recursos
//		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
//			String sql="select * from contactos";	
//			//2 Lanzamiento de instruccion sql
//			Statement st=con.createStatement();
//			ResultSet rs=st.executeQuery(sql);
//			//4 cierre de conexion en el try con recursos
//			while (rs.next()) {
//				System.out.println(rs.getString("nombre"));
//			}
//		}
		//1 Establecer conexion en el try con recursos
		//con execute en vez de executeQuery
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="select * from contactos";	
			//2 Lanzamiento de instruccion sql
			Statement st=con.createStatement();
			st.execute(sql);
			ResultSet rs=st.getResultSet();
			//4 cierre de conexion en el try con recursos
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}