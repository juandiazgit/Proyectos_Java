package excepciones_I;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Areas_Peso {
    
	static int figura;
	
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Elije una opcion:\n1. "
        						+ "Cuadrado\n2. "
        						+ "Rectangulo\n3. "
        						+ "Tri�ngulo\n4. "
        						+ "C�rculo");
        try {
        
        	figura = entrada.nextInt();
        
//        	entrada.close(); //Cierra la conexion de la consola
        	
        } catch(Exception e) {
        	System.out.println("Ha ocurrido un error!");
        } finally {
        	entrada.close(); //Cierra la conexion de la consola
        }
        
        switch(figura){
            
            case 1: 
                
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado:"));
                System.out.println(Math.pow(lado, 2));
                
                break;
                
            case 2:
                
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                
                System.out.println("El �rea del rect�ngulo es: " + base*altura);
                
                break;
                
            case 3:
                
                base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base:"));
                altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                
                System.out.println("El �rea del tri�ngulo es: " + 
                        (base*altura)/2);
                
                break;
                
            case 4:
                
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
                System.out.println("El �rea del c�rculo es: ");
                System.out.println(Math.PI*(Math.pow(radio, 2)));
                
                break;
                
            default:
                System.out.println("La opci�n no es correcta.");
        }
 //----------------------------------------------------------------------------------------------
 
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm: "));
        
        System.out.printf("Si eres hombre tu peso ideal es: %d kg.\n", altura-110);
        System.out.printf("Si eres mujer tu peso ideal es: %d kg.", altura-120);
        
    }
    
}