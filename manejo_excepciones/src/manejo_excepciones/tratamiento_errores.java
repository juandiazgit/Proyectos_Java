/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejo_excepciones;

/**
 *
 * @author Ordenador
 */
public class tratamiento_errores {
    
    private void metodo1(){
        try {
            metodo2();
        } catch (Exception e) {
            System.out.println("método 1 exception: "+e.getMessage());            
        }
    }
    
    private void metodo2() throws Exception{
        //try {
            metodo3();
        /*} catch (Exception e) {
            throw e;            
        }*/
    }
    
    private void metodo3() throws Exception{
        try {
            int division = 1/0;            
        } catch (Exception e) {
            throw new Exception("Error al dividir entre cero");
        }
    }
    
    private void lanzarException(){
        throw new ArithmeticException("Error");
    }
    
    public static void main(String args[]) {
        tratamiento_errores te= new tratamiento_errores();                
        
        te.metodo1();                         
        //te.lanzarException();
    }
    
}
