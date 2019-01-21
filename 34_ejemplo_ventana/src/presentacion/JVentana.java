package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class JVentana extends JFrame {
	public JVentana() {
		//establecemos propiedades de la ventana
		super("Calculadora"); //titulo
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		iniciarComponentes();
		this.setBounds(50, 50, 600, 300); //posición y tamaño
		this.setVisible(true); //ventana visible
	}
	void iniciarComponentes() {
		//Desactivar gestor de colocacion, layout manager
		this.setLayout(null);
		// primer numero 
		JLabel jl1=new JLabel("numero 1");
		jl1.setBounds(20, 20, 100, 20);
		this.add(jl1);
		JTextField jtf1=new JTextField();
		jtf1.setBounds(130, 20, 100, 20);
		this.add(jtf1);
		// segundo numero 
		JLabel jl2=new JLabel("numero 2");
		jl2.setBounds(20, 50, 100, 20);
		this.add(jl2);
		JTextField jtf2=new JTextField();
		jtf2.setBounds(130, 50, 100, 20);
		this.add(jtf2);
		//Crear botones 
		JButton jb1 =new JButton("Sumar");
		jb1.setBounds(20, 80, 100, 30);
		this.add(jb1);
		JButton jb2 =new JButton("Multiplicar");
		jb2.setBounds(130, 80, 100, 30);
		this.add(jb2);
		// resultado 
		JLabel jl3=new JLabel("Resultado");
		jl3.setBounds(20, 150, 100, 20);
		this.add(jl3);
		
	}
}
