package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class Procesador_II2 {

	public static void main(String[] args) {

		MenuProcesador_II2 mimarco = new MenuProcesador_II2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador_II2 extends JFrame {

	public MenuProcesador_II2() {
		
		this.setBounds(300, 200, 600, 400);
		this.setVisible(true);
		
		LaminaProcesador_II2 Lamina = new LaminaProcesador_II2();
		add(Lamina);
		
	}
}

class LaminaProcesador_II2 extends JPanel{
	
	private JTextPane miarea;
	private JMenu fuente;
	private JMenu estilo;
	private JMenu tamagno;
	private Font letras;
	private JButton negritaBarra, cursivaBarra, subraBarra, 
					azulBarra, amarilloBarra, rojoBarra, 
					a_izquierda, a_centrado, a_derecha, a_justificado;
	private JToolBar barra;
	
	public LaminaProcesador_II2() {
		
		this.setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		
		JMenuBar mibarra = new JMenuBar();
		//--------------------------------------
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamagno = new JMenu("Tamaño");
		//--------------------------------------
		configura_menu("Arial", "Fuente", "Arial", 9, 10,"");
		configura_menu("Courier", "Fuente", "Courier", 9, 10,"");
		configura_menu("Verdana", "Fuente", "Verdana", 9, 10,"");
		//--------------------------------------
//		configura_menu("Negrita", "Estilo", "", Font.BOLD, 1,"src/graficos/negrita.gif");
//		configura_menu("Cursiva", "Estilo", "", Font.ITALIC, 1,"src/graficos/cursiva.gif");
		
//		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/graficos/negrita.gif"));
//		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/graficos/cursiva.gif"));
//		negrita.addActionListener(new StyledEditorKit.BoldAction());
//		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
//		estilo.add(negrita);
//		estilo.add(cursiva);
		
		this.setCheckBoxMenuItem(estilo, "Negrita", "src/graficos/negrita.gif");
		this.setCheckBoxMenuItem(estilo, "Cursiva", "src/graficos/cursiva.gif");
		
		//--------------------------------------
//		configura_menu("12", "Tamaño", "", 9, 12,"");
//		configura_menu("16", "Tamaño", "", 9, 16,"");
//		configura_menu("20", "Tamaño", "", 9, 20,"");
//		configura_menu("24", "Tamaño", "", 9, 24,"");
		
		ButtonGroup tamagno_letra = new ButtonGroup();
		this.setRadioButtonMenuItem(tamagno, tamagno_letra, 12);
		this.setRadioButtonMenuItem(tamagno, tamagno_letra, 16);
		this.setRadioButtonMenuItem(tamagno, tamagno_letra, 20);
		this.setRadioButtonMenuItem(tamagno, tamagno_letra, 24);
		
//		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
//		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
//		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
//		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
//		tamagno_letra.add(doce);
//		tamagno_letra.add(dieciseis);
//		tamagno_letra.add(veinte);
//		tamagno_letra.add(veinticuatro);
//		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamagno", 12));
//		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamagno", 16));
//		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamagno", 20));
//		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamagno", 24));
//		tamagno.add(doce);
//		tamagno.add(dieciseis);
//		tamagno.add(veinte);
//		tamagno.add(veinticuatro);
		
		//--------------------------------------
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		
		laminaMenu.add(mibarra);
		this.add(laminaMenu,BorderLayout.NORTH);
		
		miarea = new JTextPane();
		this.add(miarea,BorderLayout.CENTER);
		
		// Menú Emergente
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negritaE = new JMenuItem("Negrita", new ImageIcon("src/graficos/negrita.gif"));
		JMenuItem cursivaE = new JMenuItem("Cursiva", new ImageIcon("src/graficos/cursiva.gif"));
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		
		miarea.setComponentPopupMenu(emergente);
		
		// Barra de herramientas
		
		barra = new JToolBar();
		
		this.configura_Barra("src/graficos/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());
		this.configura_Barra("src/graficos/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
		this.configura_Barra("src/graficos/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		this.configura_Barra("src/graficos/bola_azul.gif").addActionListener(new StyledEditorKit.ForegroundAction("Poner_azul", Color.BLUE));
		this.configura_Barra("src/graficos/bola_amarilla.gif").addActionListener(new StyledEditorKit.ForegroundAction("Poner_amarillo", Color.YELLOW));
		this.configura_Barra("src/graficos/bola_roja.gif").addActionListener(new StyledEditorKit.ForegroundAction("Poner_rojo", Color.RED));
		barra.addSeparator();
		this.configura_Barra("src/graficos/izquierda.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", StyleConstants.ALIGN_LEFT));
		this.configura_Barra("src/graficos/centrado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", StyleConstants.ALIGN_CENTER));
		this.configura_Barra("src/graficos/derecha.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", StyleConstants.ALIGN_RIGHT));
		this.configura_Barra("src/graficos/justificado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", StyleConstants.ALIGN_JUSTIFIED));
		
		barra.setOrientation(1);
		
		this.add(barra, BorderLayout.WEST);
		
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono) {
		
		JMenuItem elem_menu = new JMenuItem(rotulo,new ImageIcon(ruta_icono));
		
		if (menu.equals("Fuente")) {
			
			fuente.add(elem_menu);
			
			if (tipo_letra.equals("Arial")) {
				
				this.cambia_letra(elem_menu, "Arial");
				
			} else if (tipo_letra.equals("Courier")) {
				
				this.cambia_letra(elem_menu, "Courier");
				
			} else if (tipo_letra.equals("Verdana")) {
				
				this.cambia_letra(elem_menu, "Verdana");
				
			}
			
		} else if (menu.equals("Tamaño")) {
			
			tamagno.add(elem_menu);
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamagno", tam));
		}
		
	}
	
	private void cambia_letra(JMenuItem elem_menu, String letra) {
		
		elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", letra));
		
	}
	
	private void setCheckBoxMenuItem(JMenu estilo, String tipo_estilo, String ruta_icono) {
		
//		JCheckBoxMenuItem elem_menu = new JCheckBoxMenuItem(tipo_estilo, new ImageIcon(ruta_icono));
		JMenuItem elem_menu = new JMenuItem(tipo_estilo, new ImageIcon(ruta_icono));
		
		if (tipo_estilo.equals("Negrita")) {
			
			this.setkeyCombination(elem_menu, KeyEvent.VK_N);
			elem_menu.addActionListener(new StyledEditorKit.BoldAction());
			
		} else if (tipo_estilo.equals("Cursiva")) {
			
			this.setkeyCombination(elem_menu, KeyEvent.VK_K);
			elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			
		}
		
		estilo.add(elem_menu);
	}
	
	private void setRadioButtonMenuItem(JMenu tamagno, ButtonGroup tamagno_letra, int tam) {
		
		JRadioButtonMenuItem elem_menu = new JRadioButtonMenuItem(String.valueOf(tam));
		
//		-----------------------------
//		if (String.valueOf(tam).equals("24")) {
//			
//			elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
//			
//		}
//		-----------------------------
		
		tamagno_letra.add(elem_menu);
		elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamagno", tam));
		tamagno.add(elem_menu);
		
	}
	
	private void setkeyCombination(JMenuItem elem_menu, final int keyboardKey) {
		
		elem_menu.setAccelerator(KeyStroke.getKeyStroke(keyboardKey, InputEvent.CTRL_DOWN_MASK));
		
	}
	
	private JButton configura_Barra(String ruta) {
		
		JButton boton = new JButton(new ImageIcon(ruta));
		barra.add(boton);
		return boton;
		
	}
	
}
