package practicas;

import javax.swing.*;

public class Lamina_Botones extends JPanel{
	
	private ButtonGroup grupo;

	public Lamina_Botones(String titulo, String[] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		grupo = new ButtonGroup();
		
		for (int i = 0; i < opciones.length; i++) {
			
			JRadioButton bot = new JRadioButton(opciones[i]);
			bot.setActionCommand(opciones[i]);
			add(bot);
			grupo.add(bot);
			bot.setSelected(i==0);
			
		}
		
	}
	
	public String dameSeleccion() {
		
//		ButtonModel miboton = grupo.getSelection();
//		String s = miboton.getActionCommand();
//		return s;
		
		return grupo.getSelection().getActionCommand();
		
	}
	
}
