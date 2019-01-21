import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test {
	private static final String cadena="jdbc:mysql://localhost:3306/agenda";
	private static final String user="root";
	private static final String pwd="root";
	public static void main(String[] args) {
		try (Connection con=DriverManager.getConnection(cadena,user,pwd);){			
			String sql="Select * From Contactos";
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
											 ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(sql);
			rs.last();
			System.out.println(rs.getString("nombre"));
			rs.previous();
			System.out.println(rs.getString("nombre"));
			rs.absolute(2);
			System.out.println(rs.getString("nombre"));
			
			//modificaciones
			rs.updateInt("edad", 70);
			rs.updateRow(); //refleja la actualización en la BD
			
			//eliminación
			/*rs.last();
			rs.deleteRow();*/
			
			//añadir nueva fila
			rs.moveToInsertRow();
			rs.updateInt("idContacto", 6);
			rs.updateString("nombre", "otramas");
			rs.updateString("email", "otramas@gmail.com");
			rs.updateInt("edad", 22);
			rs.insertRow(); //refleja el cambio en la BD
			
			System.out.println(rs.getString("nombre"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}	

	}

}
