/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejo_excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Ordenador
 */
public class Manejo_excepciones {   
    static int x,y;

    public static void main(String[] args) {
        try{
            //suma();
            dividir(8, 0);
        }catch(ArithmeticException e){
            System.err.println("Mensaje de error: "+e.getMessage());
        }catch(NumberFormatException n){
            System.out.println("Error: "+n.getMessage());
        }
    }
    
    public static void suma() throws NumberFormatException{
        x = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa x: ",
                                                              "Solicitando Datos",
                                                              3));
        y = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa y: ",
                                                              "Solicitando Datos",
                                                              3));        
        JOptionPane.showMessageDialog(null,"El resultado es: "+(x+y)," Mostrando resultados",1);            
        
    }
    
    public static void dividir(int x, int y)throws ArithmeticException{
        if(y == 0){
            throw new ArithmeticException("Error, no se puede dividir entre cero");
        }else{
            JOptionPane.showMessageDialog(null, "El resultado de la división es: "+(x/y));
        }
    }
    
}
