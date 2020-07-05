package graficos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class MarcoEmergente {

	public static void main(String[] args) {

		MarcoEmergenteM mimarco = new MarcoEmergenteM();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEmergenteM extends JFrame {

	public MarcoEmergenteM() {
		
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		LamianEmergenteM Lamina = new LamianEmergenteM();
		add(Lamina);
		
	}
}

class LamianEmergenteM extends JPanel{
	
	public LamianEmergenteM() {
		
		this.setLayout(new BorderLayout());
		JPanel laminamenu = new JPanel();
		JMenuBar mibarra = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamagno = new JMenu("Tamaño");
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		laminamenu.add(mibarra);
		this.add(laminamenu, BorderLayout.NORTH);
		JTextPane miarea = new JTextPane();
		this.add(miarea, BorderLayout.CENTER);
		
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		JMenuItem opcion3 = new JMenuItem("Opcion 3");
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		
		miarea.setComponentPopupMenu(emergente);
		
	}
}


