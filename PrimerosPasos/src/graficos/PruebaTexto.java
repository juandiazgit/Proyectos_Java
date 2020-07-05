package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaTexto {

	public static void main(String[] args) {

		MarcoTexto mimarco = new MarcoTexto();		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoTexto extends JFrame {

	public MarcoTexto() {
		
		this.setTitle("Prueba Texto");
		this.setBounds(300, 200, 600, 300);
		
		LaminaTexto Lamina = new LaminaTexto();
		this.add(Lamina);
		this.setVisible(true);
		
	}
}

class LaminaTexto extends JPanel {

	private JTextField campo1;
	private JLabel resultado;
	
	public LaminaTexto() {
		
		this.setLayout(new BorderLayout());
		
		JPanel miLamina2 = new JPanel();
		miLamina2.setLayout(new FlowLayout());
		
		resultado = new JLabel("",JLabel.CENTER);
		
		JLabel texto1 = new JLabel("Email: ");
		miLamina2.add(texto1);
		
		campo1 = new JTextField(20);
		miLamina2.add(campo1);
		this.add(resultado,BorderLayout.CENTER);
		
		JButton miBoton = new JButton("Comprobar");
		DameTexto miEvento = new DameTexto();
		miBoton.addActionListener(miEvento);
		miLamina2.add(miBoton);
		
		this.add(miLamina2,BorderLayout.NORTH);
		
	}
	
	private class DameTexto implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int correcto = 0;
			String email = campo1.getText().trim();
			
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					correcto++;
				}
			}
			
			if (correcto!=1) {
				resultado.setText("Incorrecto!");
			} else {
				resultado.setText("Correcto!");
			}
			
		}
		
	}
}



