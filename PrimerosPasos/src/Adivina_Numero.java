import javax.swing.JOptionPane;

public class Adivina_Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aleatorio = (int)(Math.random()*100);
		
		int numero=0;
		int intentos=0;
		
		while (numero!=aleatorio) {
			intentos++;
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número: "));
			
			if (numero<aleatorio) {
				System.out.println("Mas alto.");
			} else if (numero>aleatorio) {
				System.out.println("Mas bajo.");
			}
		}
		System.out.println("Correcto...! N° Intentos: "+intentos);
	}

}
