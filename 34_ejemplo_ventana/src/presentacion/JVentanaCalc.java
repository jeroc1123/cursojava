package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JVentanaCalc extends JFrame {
	public JVentanaCalc() {
		//establecemos propiedades de la ventana
		super("Ventana principal"); //titulo
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		iniciarComponentes();
		this.setBounds(50, 50, 600, 300); //posición y tamaño
		this.setVisible(true); //ventana visible
	}
	void iniciarComponentes() {
		//Desactivar gestor de colocacion, layout manager
		this.setLayout(null);
		//Crear objeto
		JButton jb1 =new JButton("Pulsar aqui");
		//Propiedades
		jb1.setBounds(100, 80, 200, 60);
		//añadir objeto al contenedor
		this.add(jb1);
	}
}
