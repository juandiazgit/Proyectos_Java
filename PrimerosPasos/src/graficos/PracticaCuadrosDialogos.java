package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class PracticaCuadrosDialogos {

	public static void main(String[] args) {

		MarcoMenuPrincipal mimarco = new MarcoMenuPrincipal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoMenuPrincipal extends JFrame {

	public MarcoMenuPrincipal() {

		setBounds(350, 150, 700, 400);
		setTitle("Prueba de diálogos");

		JButton btnMostrar = new JButton("Mostrar");

		Panel_Menu LaminaMenu = new Panel_Menu(btnMostrar);
		add(LaminaMenu, BorderLayout.CENTER);

		Panel_Boton LaminaBtn = new Panel_Boton(btnMostrar);
		add(LaminaBtn, BorderLayout.SOUTH);

	}

}

class Panel_Menu extends JPanel {

	private Box caja1, caja2, caja3, caja4, caja5, caja6;

	private final String Mensaje = "Mensaje";
	private final String Confirmar = "Confirmar";
	private final String Opcion = "Opción";
	private final String Entrada = "Entrada";
	private final String ERROR_MESSAGE = "ERROR_MESSAGE";
	private final String INFORMATION_MESSAGE = "INFORMATION_MESSAGE";
	private final String WARNING_MESSAGE = "WARNING_MESSAGE";
	private final String QUESTION_MESSAGE = "QUESTION_MESSAGE";
	private final String PLAIN_MESSAGE = "PLAIN_MESSAGE";
	private final String Cadena = "Cadena";
	private final String Icono = "Icono";
	private final String Componente = "Componente";
	private final String Otros = "Otros";
	private final String Objects_Mens = "Objects[]";
	private final String DEFAULT_OPTION = "DEFAULT_OPTION";
	private final String YES_NO_OPTION = "YES_NO_OPTION";
	private final String YES_NO_CANCEL_OPTION = "YES_NO_CANCEL_OPTION";
	private final String OK_CANCEL_OPTION = "OK_CANCEL_OPTION";
	private final String String_Opc = "String[]";
	private final String Icon_Opc = "Icon[]";
	private final String Objects_Opc = "Object[]";
	private final String Campo_de_texto = "Campo de texto";
	private final String Combo = "Combo";

	private String tipo = Mensaje, tipo_mensaje = ERROR_MESSAGE, mensaje = Cadena, confirmar = DEFAULT_OPTION,
			opcion = String_Opc, entrada = Campo_de_texto;

	final String pathIconoAmarillo = "src/graficos/bola_amarilla.gif";
	final String pathIconoAzul = "src/graficos/bola_azul.gif";
	final String pathIconoRojo = "src/graficos/bola_roja.gif";
	
	Object[] listObjColor;

	public Panel_Menu(JButton btnMostrar) {

		ButtonGroup migrupo1 = new ButtonGroup();
		ButtonGroup migrupo2 = new ButtonGroup();
		ButtonGroup migrupo3 = new ButtonGroup();
		ButtonGroup migrupo4 = new ButtonGroup();
		ButtonGroup migrupo5 = new ButtonGroup();
		ButtonGroup migrupo6 = new ButtonGroup();

		this.setLayout(new GridLayout(2, 3));

		caja1 = Box.createVerticalBox();
		caja2 = Box.createVerticalBox();
		caja3 = Box.createVerticalBox();
		caja4 = Box.createVerticalBox();
		caja5 = Box.createVerticalBox();
		caja6 = Box.createVerticalBox();

		ponerBorde(caja1);
		ponerBorde(caja2);
		ponerBorde(caja3);
		ponerBorde(caja4);
		ponerBorde(caja5);
		ponerBorde(caja6);

		ponerEnCaja(caja1, Mensaje, true, migrupo1);
		ponerEnCaja(caja1, Confirmar, false, migrupo1);
		ponerEnCaja(caja1, Opcion, false, migrupo1);
		ponerEnCaja(caja1, Entrada, false, migrupo1);

		ponerEnCaja(caja2, ERROR_MESSAGE, true, migrupo2);
		ponerEnCaja(caja2, INFORMATION_MESSAGE, false, migrupo2);
		ponerEnCaja(caja2, WARNING_MESSAGE, false, migrupo2);
		ponerEnCaja(caja2, QUESTION_MESSAGE, false, migrupo2);
		ponerEnCaja(caja2, PLAIN_MESSAGE, false, migrupo2);

		ponerEnCaja(caja3, Cadena, true, migrupo3);
		ponerEnCaja(caja3, Icono, false, migrupo3);
		ponerEnCaja(caja3, Componente, false, migrupo3);
		ponerEnCaja(caja3, Otros, false, migrupo3);
		ponerEnCaja(caja3, Objects_Mens, false, migrupo3);

		ponerEnCaja(caja4, DEFAULT_OPTION, true, migrupo4);
		ponerEnCaja(caja4, YES_NO_OPTION, false, migrupo4);
		ponerEnCaja(caja4, YES_NO_CANCEL_OPTION, false, migrupo4);
		ponerEnCaja(caja4, OK_CANCEL_OPTION, false, migrupo4);

		ponerEnCaja(caja5, String_Opc, true, migrupo5);
		ponerEnCaja(caja5, Icon_Opc, false, migrupo5);
		ponerEnCaja(caja5, Objects_Opc, false, migrupo5);

		ponerEnCaja(caja6, Campo_de_texto, true, migrupo6);
		ponerEnCaja(caja6, Combo, false, migrupo6);

		btnMostrar.addActionListener(new MostrarCuadrosDialogos());
		
		listObjColor = new Object[] { "Amarillo", "Azul", "Rojo" };
		
	}

	private void ponerEnCaja(Box caja, String rotulo, boolean seleccion, ButtonGroup migrupo) {

		ponerRadioButton(rotulo, seleccion, caja, migrupo);
		this.add(caja);

	}

	private void ponerRadioButton(String nombre, boolean seleccion, Box caja, ButtonGroup migrupo) {

		JRadioButton rboton = new JRadioButton(nombre, seleccion);
		caja.add(rboton);
		migrupo.add(rboton);

		rboton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				System.out.println("---------->"+e.getActionCommand());

				if (dameTipo(e.getActionCommand())) {

					tipo = e.getActionCommand();

				} else if (dameTipoMensaje(e.getActionCommand())) {

					tipo_mensaje = e.getActionCommand();

				} else if (dameMensaje(e.getActionCommand())) {

					mensaje = e.getActionCommand();

				} else if (dameConfirmar(e.getActionCommand())) {

					confirmar = e.getActionCommand();

				} else if (dameOpcion(e.getActionCommand())) {

					opcion = e.getActionCommand();

				} else if (dameEntrada(e.getActionCommand())) {

					entrada = e.getActionCommand();

				}
				// System.out.println(tipo);
			}

		});

	}

	private void ponerBorde(Box caja) {

		if (caja.equals(caja1)) {

			caja.setBorder(BorderFactory.createTitledBorder("Tipo"));

		} else if (caja.equals(caja2)) {

			caja.setBorder(BorderFactory.createTitledBorder("Tipo de Mensaje"));

		} else if (caja.equals(caja3)) {

			caja.setBorder(BorderFactory.createTitledBorder("Mensaje"));

		} else if (caja.equals(caja4)) {

			caja.setBorder(BorderFactory.createTitledBorder("Confirmar"));

		} else if (caja.equals(caja5)) {

			caja.setBorder(BorderFactory.createTitledBorder("Opción"));

		} else if (caja.equals(caja6)) {

			caja.setBorder(BorderFactory.createTitledBorder("Entrada"));

		}

	}

	private boolean dameTipo(String tipoSel) {

		if (tipoSel.equals(Mensaje) || tipoSel.equals(Confirmar) || tipoSel.equals(Opcion) || tipoSel.equals(Entrada)) {

			return true;

		}

		return false;

	}

	private boolean dameTipoMensaje(String tipoMensSele) {

		if (tipoMensSele.equals(ERROR_MESSAGE) || tipoMensSele.equals(INFORMATION_MESSAGE)
				|| tipoMensSele.equals(WARNING_MESSAGE) || tipoMensSele.equals(QUESTION_MESSAGE)
				|| tipoMensSele.equals(PLAIN_MESSAGE)) {

			return true;

		}

		return false;

	}

	private boolean dameMensaje(String mensSele) {

		if (mensSele.equals(Cadena) || mensSele.equals(Icono) || mensSele.equals(Componente) || mensSele.equals(Otros)
				|| mensSele.equals(Objects_Mens)) {

			return true;

		}

		return false;

	}

	private boolean dameConfirmar(String confirSele) {

		if (confirSele.equals(DEFAULT_OPTION) || confirSele.equals(YES_NO_OPTION)
				|| confirSele.equals(YES_NO_CANCEL_OPTION) || confirSele.equals(OK_CANCEL_OPTION)) {

			return true;

		}

		return false;

	}

	private boolean dameOpcion(String opcionSele) {

		if (opcionSele.equals(String_Opc) || opcionSele.equals(Icon_Opc) || opcionSele.equals(Objects_Opc)) {

			return true;

		}

		return false;

	}

	private boolean dameEntrada(String entradaSele) {

		if (entradaSele.equals(Campo_de_texto) || entradaSele.equals(Combo)) {

			return true;

		}

		return false;

	}

	private int dameMessageType(String tipo_mensaje) {

		if (tipo_mensaje.equals(ERROR_MESSAGE)) {

			return JOptionPane.ERROR_MESSAGE;

		} else if (tipo_mensaje.equals(INFORMATION_MESSAGE)) {

			return JOptionPane.INFORMATION_MESSAGE;

		} else if (tipo_mensaje.equals(WARNING_MESSAGE)) {

			return JOptionPane.WARNING_MESSAGE;

		} else if (tipo_mensaje.equals(QUESTION_MESSAGE)) {

			return JOptionPane.QUESTION_MESSAGE;

		} else { // if (tipo_mensaje.equals(PLAIN_MESSAGE)

			return JOptionPane.PLAIN_MESSAGE;

		}

	}

	private int dameOptionType(String confirmar) {

		if (confirmar.equals(DEFAULT_OPTION)) {

			return JOptionPane.DEFAULT_OPTION;

		} else if (confirmar.equals(YES_NO_OPTION)) {

			return JOptionPane.YES_NO_OPTION;

		} else if (confirmar.equals(YES_NO_CANCEL_OPTION)) {

			return JOptionPane.YES_NO_CANCEL_OPTION;

		} else { // confirmar.equals(OK_CANCEL_OPTION)

			return JOptionPane.OK_CANCEL_OPTION;

		}

	}

	private Object dameMessage(String mensaje) {

		final String Mensajes = "Mensajes";

		Icon imagenBola = dameIcono(pathIconoAzul);

		JPanel laminaMensaje = new JPanel();
		laminaMensaje.setBackground(Color.YELLOW);
		laminaMensaje.setBorder(new LineBorder(new Color(100)));

		Date fecha = new Date();

		if (mensaje.equals(Cadena)) {

			return Mensajes;

		} else if (mensaje.equals(Icono)) {

			return imagenBola;

		} else if (mensaje.equals(Componente)) {

			return laminaMensaje;

		} else if (mensaje.equals(Otros)) {

			return fecha.toString();

		} else { // if (mensaje.equals(Objects_Mens))

			return new LaminaConObjetos(pathIconoAzul, Mensajes, fecha);

		}

	}

	private Object[] dameOptions(String opcion) {

		final String Mensajes = "Mensajes";
		JPanel laminaMensaje = new JPanel();
		laminaMensaje.setBackground(Color.YELLOW);
		laminaMensaje.setBorder(new LineBorder(new Color(100)));
		Object[] listObjts = null;

		if (opcion.equals(String_Opc)) {

			return listObjColor;

		} else if (opcion.equals(Icon_Opc)) {

			listObjts = new Object[] { dameIcono(pathIconoAmarillo), dameIcono(pathIconoAzul), dameIcono(pathIconoRojo) };
			
		} else if (opcion.equals(Objects_Opc)) {

			listObjts = new Object[] { Mensajes, dameIcono(pathIconoAzul), laminaMensaje, new Date().toString() };
			
		}

		return listObjts;

	}

	private Icon dameIcono(String pathIcono) {

		return new ImageIcon(pathIcono);

	}
	
	private Object[] dameEntry(String entrada) {
		
		if (entrada.equals(Combo)) {

			return listObjColor;

		}
		
		return null;
		
	}

	private class MostrarCuadrosDialogos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("-------------------------------");
			System.out.println(tipo);
			System.out.println(tipo_mensaje);
			System.out.println(mensaje);
			System.out.println(confirmar);
			System.out.println(opcion);
			System.out.println(entrada);

			if (tipo.equals(Mensaje)) {

				JOptionPane.showMessageDialog(Panel_Menu.this, dameMessage(mensaje), "Titulo",
						dameMessageType(tipo_mensaje));

			} else if (tipo.equals(Confirmar)) {

				JOptionPane.showConfirmDialog(Panel_Menu.this, dameMessage(mensaje), "Titulo",
						dameOptionType(confirmar), dameMessageType(tipo_mensaje), null);

			} else if (tipo.equals(Opcion)) {

				JOptionPane.showOptionDialog(Panel_Menu.this, dameMessage(mensaje), "Titulo", dameOptionType(confirmar),
						dameMessageType(tipo_mensaje), null, dameOptions(opcion), null);

			} else if (tipo.equals(Entrada)) {
			
				JOptionPane.showInputDialog(Panel_Menu.this, dameMessage(mensaje), "Titulo",
						dameMessageType(tipo_mensaje), null, dameEntry(entrada), null);

			}

		}

	}

}

class Panel_Boton extends JPanel {

	public Panel_Boton(JButton btnMostrar) {

		this.setLayout(new FlowLayout());
		this.add(btnMostrar);

	}
}

class LaminaConObjetos extends JPanel {

	private Image imagenBola;
	private String mensajes;
	private Date fecha;

	public LaminaConObjetos(String pathIcono, String mensajes, Date fecha) {

		this.mensajes = mensajes;
		try {
			imagenBola = ImageIO.read(new File(pathIcono));
		} catch (IOException e) {
			System.out.println("La imagen no se encuentra !");
		}
		this.fecha = fecha;

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawString(this.mensajes, 10, 10);
		g.drawImage(this.imagenBola, 80, 1, null);
		g.drawString(String.valueOf(fecha), 10, 25);

		Graphics2D gr = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double(10, 25, 180, 6);
		gr.setPaint(Color.BLACK);
		gr.draw(rect);
		gr.setPaint(Color.YELLOW);
		gr.fill(rect);

	}

}