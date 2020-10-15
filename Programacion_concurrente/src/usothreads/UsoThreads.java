package usothreads;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {

		JFrame marco = new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);

	}

}

class PelotaHilos implements Runnable{
	
	private Pelota pelota;
	private Component componente;
	
	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		
		this.pelota = unaPelota;
		this.componente = unComponente; 
		
	}

	@Override
	public void run() {
		
		System.out.println("Estado del hilo al comenzar: "+Thread.currentThread().isInterrupted());

//		for (int i = 1; i <= 3000; i++) {
//		while (!Thread.interrupted()) {
		while (!Thread.currentThread().isInterrupted()) {
		
			pelota.mueve_pelota(componente.getBounds());

//			componente.paint(componente.getGraphics());
			componente.repaint();
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
//				System.out.println("Hilo bloqueado. Imposible su interrupción");
//				e.printStackTrace();
//				System.exit(0);
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println("Estado del hilo al terminar: "+Thread.currentThread().isInterrupted());
		
	}
	
}

//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota {

	private static final int TAMX = 15;

	private static final int TAMY = 15;

	private double x = 0;

	private double y = 0;

	private double dx = 1;

	private double dy = 1;

	// Mueve la pelota invirtiendo posición si choca con límites

	public void mueve_pelota(Rectangle2D limites) {

		x += dx;

		y += dy;

		if (x < limites.getMinX()) {

			x = limites.getMinX();

			dx = -dx;
		}

		if (x + TAMX >= limites.getMaxX()) {

			x = limites.getMaxX() - TAMX;

			dx = -dx;
		}

		if (y < limites.getMinY()) {

			y = limites.getMinY();

			dy = -dy;
		}

		if (y + TAMY >= limites.getMaxY()) {

			y = limites.getMaxY() - TAMY;

			dy = -dy;

		}

	}

	// Forma de la pelota en su posición inicial

	public Ellipse2D getShape() {

		return new Ellipse2D.Double(x, y, TAMX, TAMY);

	}

}

// Lámina que dibuja las pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
	
	// Añadimos pelota a la lámina

	public void add(Pelota b) {

		pelotas.add(b);
		
	}
	

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (Pelota b : pelotas) {

			g2.fill(b.getShape());
		}
		
//		Toolkit.getDefaultToolkit().sync();
		revalidate();

	}

}

//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private LaminaPelota lamina;
	
	private Thread t1,t2,t3;
	
	private JButton boton;

	public MarcoRebote() {

		setBounds(600, 300, 600, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();
		
		//-------------------------------------------------------------
		agregarBotones("Hilo1", laminaBotones);
		agregarBotones("Hilo2", laminaBotones);
		agregarBotones("Hilo3", laminaBotones);
		//-------------------------------------------------------------
		detenerHilo("Detener1", laminaBotones);
		detenerHilo("Detener2", laminaBotones);
		detenerHilo("Detener3", laminaBotones);
		//-------------------------------------------------------------
		
		add(laminaBotones, BorderLayout.SOUTH);
	}

	// Añade pelota y la bota 1000 veces

	public void comienza_el_juego(ActionEvent e) {

		Pelota pelota = new Pelota();

		lamina.add(pelota);

		Runnable r = new PelotaHilos(pelota, lamina);
		
//		Thread t = new Thread(r);
		
		if (e.getActionCommand().equals("Hilo1")) {
			
			t1 = new Thread(r);
			t1.start();
			
		} else if (e.getActionCommand().equals("Hilo2")) {
			
			t2 = new Thread(r);
			t2.start();
			
		} else if (e.getActionCommand().equals("Hilo3")) {
			
			t3 = new Thread(r);
			t3.start();
			
		} 

	}
	
	public void detener(ActionEvent e) {
		
//		t.stop();
		
//		if (t == null) {
//			System.out.println("No se ha iniciado ningún hilo");
//			return;
//		}
		
		if (e.getActionCommand().equals("Detener1")) {
			
			t1.interrupt();
			
		} else if (e.getActionCommand().equals("Detener2")) {
			
			t2.interrupt();
			
		} else if (e.getActionCommand().equals("Detener3")) {
			
			t3.interrupt();
			
		}
		
	}
	
	public void agregarBotones(String nombreHilo, JPanel laminaBotones) {
		
		boton = new JButton(nombreHilo);
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				
				comienza_el_juego(evento);
				
			}
		});
		
		laminaBotones.add(boton);
		
	}
	
	public void detenerHilo(String nombreHilo, JPanel laminaBotones) {
		
		boton = new JButton(nombreHilo);
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				
				detener(evento);
				
			}
		});
		
		laminaBotones.add(boton);
		
	}

}
