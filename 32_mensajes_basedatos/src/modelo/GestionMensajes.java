package modelo;

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
	
	private static final String cadena="jdbc:mysql://localhost:3306/agenda";
	private static final String user="root";
	private static final String pwd="root";
	
	public void altaMensaje(Mensaje m) {
		try (Connection con=DriverManager.getConnection(cadena,user,pwd);){	
			
			String sql="Insert Into mensajes (texto,idContacto,fecha) values(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, m.getTexto());
			st.setInt(2, m.getIdContacto());
			st.setTimestamp(3, new java.sql.Timestamp(m.getFecha().getTime()));
			st.execute();
			
		}
		catch(SQLException ex) {
			
			ex.printStackTrace();
			
		}		
	}
	
	public List<Mensaje> obtenerMensajes(){
		
		List<Mensaje> listado=new ArrayList<>();
		try (Connection con=DriverManager.getConnection(cadena,user,pwd);){			
			String sql="Select * From mensajes";
			//lanzamiento de instrucción SQL
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);						
			while(rs.next()) {
				listado.add(new Mensaje(
						rs.getInt("idMensaje"),
						rs.getString("texto"),
						rs.getInt("idContacto"),
						rs.getDate("fecha")
						));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}	
		return listado;
	}
}
