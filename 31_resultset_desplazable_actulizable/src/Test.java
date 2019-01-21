import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	private final static String cadena="jdbc:mysql://localhost:3306/agenda";
	private final static String user="root";
	private final static String pwd="root";
	
	public static void main(String[] args) {
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="select * from contactos";	
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(sql);
//			rs.last();
//			System.out.println(rs.getString("nombre"));
//			rs.previous();
//			System.out.println(rs.getString("nombre"));
//			rs.absolute(5);
//			System.out.println(rs.getString("nombre"));
			//modificaciones. sobre el campo edad, del segundo registro se actualiza la edad
//			rs.updateInt("edad",35 );
//			rs.updateRow(); //Refleja la actualizacion
			//borrado. nos posicionamos en la ultima y borramos
			rs.last();
			rs.deleteRow();
			//añadir nueva fila
//			rs.moveToInsertRow();
//			rs.updateString("nombre","contacto nuevo3" );
//			rs.updateString("email","contactonuevo3@gmail.com" );
//			rs.updateInt("edad",37 );
//			rs.insertRow();
			System.out.println(rs.getString("nombre"));
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}