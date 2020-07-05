package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos_Ventana {

	public static void main(String[] args) {
		
		MarcoVentana mimarco = new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MarcoVentana mimarco2 = new MarcoVentana();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mimarco.setTitle("Ventana 1");
		mimarco2.setTitle("Ventana 2");
		
		mimarco.setBounds(150, 200, 500, 350);
		
		mimarco2.setBounds(700, 200, 500, 350);
	}

}

class MarcoVentana extends JFrame{
	
	public MarcoVentana() {
		
//		setTitle("Respondiendo");
//		setBounds(450, 200, 400, 300);
		setVisible(true);
		
//		M_Ventana oyente_ventana = new M_Ventana();
//		this.addWindowListener(oyente_ventana);
		
		this.addWindowListener(new M_Ventana());
	}
}

class M_Ventana extends WindowAdapter{

	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada.");
	}
}