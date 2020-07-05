package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaChecks {

	public static void main(String[] args) {

		MarcoCheck mimarco = new MarcoCheck();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCheck extends JFrame {

	public MarcoCheck() {
		
		this.setTitle("Prueba Checks");
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		LaminaCheck Lamina = new LaminaCheck();
		add(Lamina);
		
	}
}

class LaminaCheck extends JPanel {

	private JLabel texto;
	private JCheckBox check1, check2;
	
	public LaminaCheck() {
		
		this.setLayout(new BorderLayout());
		Font miletra = new Font("Serif", Font.PLAIN, 24);
		texto = new JLabel("En un lugar de la mancha de cuyo nombre ...");
		texto.setFont(miletra);
		
		JPanel laminaTexto = new JPanel();
		laminaTexto.add(texto);
		
		this.add(laminaTexto, BorderLayout.CENTER);
		
		check1 = new JCheckBox("Negrita");
		check2 = new JCheckBox("Cursiva");
		
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		
		JPanel lamianChecks = new JPanel();
		lamianChecks.add(check1);
		lamianChecks.add(check2);
		
		this.add(lamianChecks,BorderLayout.SOUTH);
		
	}
	
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int tipo = 0;
			
			if(check1.isSelected())
				tipo+=Font.BOLD;
			
			if (check2.isSelected())
				tipo+=Font.ITALIC;
			
			texto.setFont(new Font("Serif", tipo, 24));
			
		}
		
	}
}


