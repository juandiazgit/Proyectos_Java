package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Procesador_II {

	public static void main(String[] args) {

		MenuProcesador_II mimarco = new MenuProcesador_II();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador_II extends JFrame {

	public MenuProcesador_II() {
		
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		LaminaProcesador_II Lamina = new LaminaProcesador_II();
		add(Lamina);
		
	}
}

class LaminaProcesador_II extends JPanel{
	
	private JTextPane miarea;
	private JMenu fuente;
	private JMenu estilo;
	private JMenu tamagno;
	private Font letras;
	
	public LaminaProcesador_II() {
		
		this.setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		
		JMenuBar mibarra = new JMenuBar();
		//--------------------------------------
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamagno = new JMenu("Tamaño");
		//--------------------------------------
		configura_menu("Arial", "Fuente", "Arial", 9, 10);
		configura_menu("Courier", "Fuente", "Courier", 9, 10);
		configura_menu("Verdana", "Fuente", "Verdana", 9, 10);
		//--------------------------------------
		configura_menu("Negrita", "Estilo", "", Font.BOLD, 1);
		configura_menu("Cursiva", "Estilo", "", Font.ITALIC, 1);
		//--------------------------------------
		configura_menu("12", "Tamaño", "", 9, 12);
		configura_menu("16", "Tamaño", "", 9, 16);
		configura_menu("20", "Tamaño", "", 9, 20);
		configura_menu("24", "Tamaño", "", 9, 24);
		//--------------------------------------
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		
		laminaMenu.add(mibarra);
		this.add(laminaMenu,BorderLayout.NORTH);
		
		miarea = new JTextPane();
		this.add(miarea,BorderLayout.CENTER);
		
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {
		
		JMenuItem elem_menu = new JMenuItem(rotulo);
		
		if (menu.equals("Fuente")) {
			fuente.add(elem_menu);
		} else if (menu.equals("Estilo")) {
			estilo.add(elem_menu);
		} else if (menu.equals("Tamaño")) {
			tamagno.add(elem_menu);
		}
		
		elem_menu.addActionListener(new Gestiona_eventos(rotulo, tipo_letra, estilos, tam));
	}
	
	private class Gestiona_eventos implements ActionListener{

		String tipo_texto, menu;
		int estilo_letra, tamagno_letra;
		
		public Gestiona_eventos(String menu, String tipo_texto, int estilo_letra, int tamagno_letra) {
			
			this.tipo_texto = tipo_texto;
			this.estilo_letra = estilo_letra;
			this.tamagno_letra = tamagno_letra;
			this.menu = menu;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			letras = miarea.getFont();
			
			if (menu.equals("Arial") || menu.equals("Courier") || menu.equals("Verdana")) {
				
				this.estilo_letra = letras.getStyle();
				this.tamagno_letra = letras.getSize();
				
			} else if (menu.equals("Negrita") || menu.equals("Cursiva")) {
				
				if (letras.getStyle() == Font.BOLD || letras.getStyle() == Font.ITALIC) {
					this.estilo_letra = Font.BOLD+Font.ITALIC;
				}
				
				this.tipo_texto = letras.getFontName();
				this.tamagno_letra = letras.getSize();
				
			} else if (menu.equals("12") || menu.equals("16") || menu.equals("20") || menu.equals("24")) {
				
				this.estilo_letra = letras.getStyle();
				this.tipo_texto = letras.getFontName();
				
			}
			
			miarea.setFont(new Font(tipo_texto, estilo_letra, tamagno_letra));
			
			System.out.println("Tipo texto: "+tipo_texto+", Estilo: "+estilo_letra+", Tamaño: "+tamagno_letra);
		}
		
	}
	
}


