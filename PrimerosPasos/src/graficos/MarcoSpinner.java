package graficos;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MarcoSpinner {

	public static void main(String[] args) {

		FrameSpinner mimarco = new FrameSpinner();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSpinner extends JFrame {

	public FrameSpinner() {
		
		this.setTitle("Prueba Spinner");
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		LaminaSpinner Lamina = new LaminaSpinner();
		add(Lamina);
		
	}
}

class LaminaSpinner extends JPanel{
	
	public LaminaSpinner() {
		
//		String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {
			
			@Override
			public Object getNextValue() {
				return super.getPreviousValue();
			}
	
			@Override
			public Object getPreviousValue() {
				return super.getNextValue();
			}
			
		});
		control.setPreferredSize(new Dimension(200, 20));
		
		this.add(control);
		
	}
	
//	private class MiModeloSpinner extends SpinnerNumberModel{
//
//		public MiModeloSpinner() {
//			super(5, 0, 10, 1);
//		}
//
//		@Override
//		public Object getNextValue() {
//			return super.getPreviousValue();
//		}
//
//		@Override
//		public Object getPreviousValue() {
//			return super.getNextValue();
//		}
//		
//	}
	
}


