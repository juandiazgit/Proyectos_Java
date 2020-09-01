package mis_applets;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Hola_Alumnos extends JApplet{

	@Override
	public void init() {
			
		JLabel rotulo = new JLabel("Hola alumnos",SwingConstants.CENTER);
		add(rotulo);
		
	}
	
}
