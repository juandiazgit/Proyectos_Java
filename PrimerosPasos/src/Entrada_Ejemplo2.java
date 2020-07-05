import javax.swing.*;

public class Entrada_Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre: ");
		String edad = JOptionPane.showInputDialog("Introduce la edad: ");
		int edadConv = Integer.parseInt(edad);
		
		System.out.println("Nombre: "+nombre);
		System.out.println("Edad el próximo año: "+(edadConv+1));
	}

}
