package mis_applets;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

public class Grafico_Applet extends JApplet{

	public void init(){
		
		int arrayGraficos[] = new int[7];
		
		for (int i = 0; i < arrayGraficos.length; i++) {
			
			arrayGraficos[i] = LaminaGrafico.getRandomNumber(150);
					
		}
	
		LaminaGrafico milamina=new LaminaGrafico(arrayGraficos);
		
		add(milamina);
		
	}

}

class LaminaGrafico extends JPanel{
	
	private int valores_Graficos[];
	private Color color_barra;
	
	public LaminaGrafico(int valores[]) {
		
		valores_Graficos = valores;
		
	}

	public void paint(Graphics g){
		
		int pos_x = 0;
		int color_rojo,color_verde,color_azul;
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		g2.rotate( 180/180.0 * Math.PI, 125, 100);
		
		for (int i = 0; i < valores_Graficos.length; i++) {
			
			Rectangle2D graf=new Rectangle2D.Double(pos_x,0,25,valores_Graficos[i]);
			color_rojo = getRandomNumber(200);
			color_verde = getRandomNumber(200);
			color_azul = getRandomNumber(200);
			color_barra = new Color(color_rojo, color_verde, color_azul);
			g2.setPaint(color_barra);
			g2.fill(graf);
			pos_x += 25;
			
		}
		
	}
	
	public static int getRandomNumber(int limite) {
		
		return (int)Math.round((Math.random()*limite));
		
	}
	
}
