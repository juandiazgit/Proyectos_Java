package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		
		MarcoConFuentes mimarco = new MarcoConFuentes();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConFuentes extends JFrame{
	
	public MarcoConFuentes() {
		
		setTitle("Prueba con Fuentes.");
		setSize(400, 400);
		
		LaminasConFuentes miLamina = new LaminasConFuentes();
		
		//Adiciona la lámina al contenedor. 
		add(miLamina);
		
		miLamina.setForeground(Color.BLUE);
		
	}
}

class LaminasConFuentes extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		Font fuente = new Font("Cambria", Font.BOLD, 26);
		
		g2.setFont(fuente);
		
//		g2.setColor(Color.BLUE);
		
		g2.drawString("Juan Guillermo", 100, 100);
		
		g2.setFont(new Font("Arial", Font.ITALIC, 24));
		
//		g2.setColor(new Color(128, 90, 50).brighter());
		
		g2.drawString("Curso de Java.", 100, 200);
	}
}



