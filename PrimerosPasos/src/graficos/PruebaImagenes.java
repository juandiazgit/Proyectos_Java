package graficos;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		
		MarcoImagen mimarco = new MarcoImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
		
		setTitle("Prueba con Imagen.");
		setBounds(550, 200, 400, 300);
		
		LaminasConImagenes miLamina = new LaminasConImagenes();
		
		//Adiciona la lámina al contenedor. 
		add(miLamina);
		
	}
}

class LaminasConImagenes extends JPanel{
	
	private Image imagen;
	
	public LaminasConImagenes() {
		try {
			imagen = ImageIO.read(new File("src/graficos/bola.gif"));
		} catch (IOException e) {
			System.out.println("La imagen no se encuentra !");
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
//		File miimagen = new File("src/graficos/coche.png");

		/*El "this" referencia a un objeto de la clase en la que estoy,
		  es decir un objeto de la clase "LaminasConImagenes"*/
		int anchuraImagen = imagen.getWidth(this);
		int alturaImagen = imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		for (int i = 0; i < 300; i++) {
			
			for (int j = 0; j < 200; j++) {
				
				if (i+j > 0) {
					g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
				}
			}
		}
		
	}
}



