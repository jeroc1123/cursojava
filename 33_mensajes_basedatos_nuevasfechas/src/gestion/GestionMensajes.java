package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Mensaje;

public class GestionMensajes {
	private final static String cadena="jdbc:mysql://localhost:3306/agenda";
	private final static String user="root";
	private final static String pwd="root";
	
	public void altaMensaje(Mensaje m) {

		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="insert into mensajes (texto, idContacto, fecha) values (?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, m.getTexto());
			st.setInt(2, m.getIdContacto());
			st.setTimestamp(3, java.sql.Timestamp.valueOf(m.getFecha()));
			st.execute();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Mensaje> obtenerMensajes(){
		List<Mensaje> listado=new ArrayList<>();
		
		try (Connection con=DriverManager.getConnection(cadena, user,pwd);){
			String sql="select idMensaje, mensaje, idContacto, fecha from mensajes";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next()) {
				listado.add(new Mensaje(
							rs.getInt("idMensaje"),
							rs.getString("texto"),
							rs.getInt("idContacto"),
							rs.getTimestamp("fecha").toLocalDateTime()
							));
		}
		return listado;	
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}
}
