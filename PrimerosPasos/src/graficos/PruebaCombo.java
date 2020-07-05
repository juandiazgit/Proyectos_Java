package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaCombo {

	public static void main(String[] args) {

		MarcoCombo mimarco = new MarcoCombo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCombo extends JFrame {

	public MarcoCombo() {
		
		this.setTitle("Prueba ComboBox");
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		LaminaCombo Lamina = new LaminaCombo();
		add(Lamina);
		
	}
}

class LaminaCombo extends JPanel{
	
	private JLabel texto;
	private JComboBox micombo;
	
	public LaminaCombo() {

		this.setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la mancha de cuyo nombre ...");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		this.add(texto,BorderLayout.CENTER);
		
		JPanel lamina_norte = new JPanel();
		micombo = new JComboBox();
		micombo.setEditable(true);
		micombo.addItem("Serif");
		micombo.addItem("SansSerif");
		micombo.addItem("Monospaced");
		micombo.addItem("Dialog");
		
		Evento_Combo mievento = new Evento_Combo();
		micombo.addActionListener(mievento);
		
		lamina_norte.add(micombo);
		this.add(lamina_norte, BorderLayout.NORTH);
		
	}
	
	private class Evento_Combo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN, 18));
			
		}
		
	}
	
}


