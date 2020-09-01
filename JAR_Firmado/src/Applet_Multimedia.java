import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

public class Applet_Multimedia extends JApplet{

	private Image logo;
	
	public void init() {
		
		logo = getImage(getDocumentBase(), "logo.jpg");
		
	}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		g.drawImage(logo, 20, 20, this);
		
	}
	
}
