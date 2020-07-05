package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CampoPassword {

	public static void main(String[] args) {

		MarcoPassword mimarco = new MarcoPassword();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoPassword extends JFrame {

	public MarcoPassword() {
		
		this.setBounds(300, 200, 400, 300);

		LaminaPassword Lamina = new LaminaPassword();
		this.add(Lamina);
		this.setVisible(true);

	}
}

class LaminaPassword extends JPanel {
	
	private JPasswordField c_contra;

	public LaminaPassword() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_superior = new JPanel();
		lamina_superior.setLayout(new GridLayout(2,2));
		add(lamina_superior,BorderLayout.NORTH);
		
		JLabel etiqueta1 = new JLabel("Usuario");
		JLabel etiqueta2 = new JLabel("Contraseña");
		JTextField c_usuario = new JTextField(3);
		
		Comprueba_pass mievento = new Comprueba_pass();
		c_contra = new JPasswordField(15);
		c_contra.getDocument().addDocumentListener(mievento);
		
		lamina_superior.add(etiqueta1);
		lamina_superior.add(c_usuario);
		lamina_superior.add(etiqueta2);
		lamina_superior.add(c_contra);
		
		JButton enviar = new JButton("Enviar");
		add(enviar,BorderLayout.SOUTH);
		
	}
	
	private class Comprueba_pass implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			
			this.verifyPassword();
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
		
			this.verifyPassword();
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		private void verifyPassword() {
			char [] contrasena;
			contrasena = c_contra.getPassword();
			
			if (contrasena.length < 8 || contrasena.length > 12) {
				c_contra.setBackground(Color.RED);
			}else {
				c_contra.setBackground(Color.WHITE);
			}
		}
		
	}

}
