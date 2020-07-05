package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaColor {

	public static void main(String[] args) {
		
		MarcoConColor mimarco = new MarcoConColor();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConColor extends JFrame{
	
	public MarcoConColor() {
		setTitle("Prueba de Dibujo");
		setSize(400, 400);
		
		LaminasConColor miLamina = new LaminasConColor();

		//Adiciona la lámina al contenedor. 
		add(miLamina);
		
		miLamina.setBackground(SystemColor.window);
	}
}

class LaminasConColor extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.setPaint(Color.BLUE);
		g2.draw(rectangulo);
		g2.setPaint(Color.RED);
		g2.fill(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		Color micolor = new Color(125, 189, 200);
		g2.setPaint(micolor);
		elipse.setFrame(rectangulo);
		g2.fill(elipse);
		
	}
}



