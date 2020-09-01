package mis_applets;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Calculadora extends JApplet{

	public void init() {

		add(new LaminaCalculadora());

	}

}

class LaminaCalculadora extends JPanel {

	private JPanel miLamina2;
	private JButton pantalla;
	private boolean principio; // Es false por defecto si no se inicializa
	private double resultado;
	private String ultimaOperacion;

	public LaminaCalculadora() {

		setLayout(new BorderLayout());
		principio = true;
		pantalla = new JButton("0");
		pantalla.setEnabled(false);
		this.add(pantalla, BorderLayout.NORTH);

		miLamina2 = new JPanel();
		miLamina2.setLayout(new GridLayout(4, 4));

		ActionListener inserta = new InsertaNumero();
		ActionListener orden = new AccionOrden();
		this.ponerBoton("7", inserta);
		this.ponerBoton("8", inserta);
		this.ponerBoton("9", inserta);
		this.ponerBoton("/", orden);
		this.ponerBoton("4", inserta);
		this.ponerBoton("5", inserta);
		this.ponerBoton("6", inserta);
		this.ponerBoton("*", orden);
		this.ponerBoton("1", inserta);
		this.ponerBoton("2", inserta);
		this.ponerBoton("3", inserta);
		this.ponerBoton("-", orden);
		this.ponerBoton("0", inserta);
		this.ponerBoton(".", inserta);
		this.ponerBoton("=", orden);
		this.ponerBoton("+", orden);
		this.add(miLamina2, BorderLayout.CENTER);
		this.ultimaOperacion = "=";
	}

	private void ponerBoton(String rotulo, ActionListener oyente) {

		JButton boton = new JButton(rotulo);
		miLamina2.add(boton);
		boton.addActionListener(oyente);

	}

	private class InsertaNumero implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String entrada = e.getActionCommand();

			if (principio) {
				pantalla.setText("");
				principio = false;
			}
			pantalla.setText(pantalla.getText() + entrada);

		}

	}

	private class AccionOrden implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String operacion = e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion = operacion;
			principio = true;

		}

		public void calcular(double x) {

			if (ultimaOperacion.equals("+")) {
				resultado += x;
			} else if (ultimaOperacion.equals("-")) {
				resultado -= x;
			} else if (ultimaOperacion.equals("*")) {
				resultado *= x;
			} else if (ultimaOperacion.equals("/")) {
				resultado /= x;
			} else if (ultimaOperacion.equals("=")) {
				resultado = x;
			}
			
			pantalla.setText(""+resultado); //La comillas vacías convierten el Double en String.

		}

	}
}
