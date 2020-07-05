package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class PruebaTexto2 {

	public static void main(String[] args) {

		MarcoPrueba mimarco = new MarcoPrueba();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoPrueba extends JFrame {

	public MarcoPrueba() {

		this.setTitle("Prueba Texto 2");
		this.setBounds(300, 200, 600, 300);

		LaminaPrueba Lamina = new LaminaPrueba();
		this.add(Lamina);
		this.setVisible(true);

	}
}

class LaminaPrueba extends JPanel {

	public LaminaPrueba() {

		JTextField micampo = new JTextField(20);
		EscuchaTexto el_evento = new EscuchaTexto();
		Document midoc = micampo.getDocument();
		midoc.addDocumentListener(el_evento);
		this.add(micampo);

	}

	private class EscuchaTexto implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {

			System.out.println("Has insertado texto");

		}

		public void removeUpdate(DocumentEvent e) {

			System.out.println("Has borrado texto");

		}

		public void changedUpdate(DocumentEvent e) {}

	}

}
