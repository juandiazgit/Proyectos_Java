package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VariosOyentes {

	public static void main(String[] args) {

		Marco_Principal mimarco = new Marco_Principal();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_Principal extends JFrame {

	public Marco_Principal() {
		this.setTitle("Prueba Varios");
		this.setBounds(500, 200, 600, 300);

		Lamina_Principal Lamina = new Lamina_Principal();

		// Adiciona la lámina al contenedor.
		add(Lamina);
	}
}

class Lamina_Principal extends JPanel {

	JButton boton_cerrar;

	public Lamina_Principal() {

		JButton boton_nuevo = new JButton("Nuevo");
		this.add(boton_nuevo);
		boton_cerrar = new JButton("Cerrar todo");
		this.add(boton_cerrar);

		OyenteNuevo miOyente = new OyenteNuevo();
		boton_nuevo.addActionListener(miOyente);

	}

	private class OyenteNuevo implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Marco_Emergente marco = new Marco_Emergente(boton_cerrar);
			marco.setVisible(true);

		}
	}
}

class Marco_Emergente extends JFrame {

	private static int contador = 0;

	public Marco_Emergente(JButton boton_de_principal) {
		
		contador++;
		this.setTitle("Ventana " + contador);
		this.setBounds(40 * contador, 40 * contador, 300, 150);
		
		CierraTodos oyenteCerrar = new CierraTodos();
		boton_de_principal.addActionListener(oyenteCerrar);
		
	}

	private class CierraTodos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			dispose();

		}
	}
}
