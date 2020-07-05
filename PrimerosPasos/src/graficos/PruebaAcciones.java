package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {

	public static void main(String[] args) {

		MarcoAccion mimarco = new MarcoAccion();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoAccion extends JFrame {

	public MarcoAccion() {
		this.setTitle("Prueba Acciones");
		this.setBounds(300, 200, 600, 300);

		PanelAccion Lamina = new PanelAccion();

		// Adiciona la lámina al contenedor.
		add(Lamina);
	}
}

class PanelAccion extends JPanel {

	public PanelAccion() {

		AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/bola_amarilla.gif"),
				Color.YELLOW);
		AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/bola_azul.gif"), Color.BLUE);
		AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/bola_roja.gif"), Color.RED);

//		JButton botonAmarillo = new JButton(accionAmarillo);
//		this.add(botonAmarillo);

		this.add(new JButton(accionAmarillo));
		this.add(new JButton(accionAzul));
		this.add(new JButton(accionRojo));
		
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		
		ActionMap mapaAccion = getActionMap();
		
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}

	private class AccionColor extends AbstractAction {

		public AccionColor(String nombre, Icon icono, Color color_boton) {

			this.putValue(Action.NAME, nombre);
			this.putValue(Action.SMALL_ICON, icono);
			this.putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
			this.putValue("color_de_fondo", color_boton);

		}

		public void actionPerformed(ActionEvent e) {
			Color c = (Color) this.getValue("color_de_fondo");
			setBackground(c);
			
			System.out.println("Nombre: "+getValue(Action.NAME));
		}
	}
}
