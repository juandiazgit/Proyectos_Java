package graficos;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class MarcoMenu {

	public static void main(String[] args) {

		MenuFrame mimarco = new MenuFrame();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuFrame extends JFrame {

	public MenuFrame() {
		
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		MenuLamina Lamina = new MenuLamina();
		add(Lamina);
		
	}
}

class MenuLamina extends JPanel{
	
	public MenuLamina() {
		
		this.setLayout(new BorderLayout());
		
		JMenuBar mibarra = new JMenuBar();
		JTextPane miarea = new JTextPane();
		JPanel laminaMenu = new JPanel();
		
		JMenu archivo = new JMenu("Archivo"); 
		JMenu edicion = new JMenu("Edición");
		JMenu herramientas = new JMenu("Herramientas");
		JMenu opciones = new JMenu("Opciones");
		
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardar_como = new JMenuItem("Guardar como");
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/graficos/cortar.gif"));
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/graficos/copiar.gif"));
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/pegar.gif"));
		JMenuItem generales = new JMenuItem("Generales");
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		archivo.add(guardar);
		archivo.add(guardar_como);
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator();
		opciones.add(opcion1);
		opciones.add(opcion2);
		edicion.add(opciones);
		herramientas.add(generales);
		
		mibarra.add(archivo);
		mibarra.add(edicion);
		mibarra.add(herramientas);
		
		laminaMenu.add(mibarra);
		this.add(laminaMenu,BorderLayout.NORTH);
		this.add(miarea, BorderLayout.CENTER);
		
	}
	
}


