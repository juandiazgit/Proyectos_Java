/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ordenador
 */
public class claseMain {
    
    public static void main(String... jgdm) {
        
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese su edad: ");
            int edad = sc.nextInt();
            final int EDAD_MAXIMA = 100;
         
            if(edad < EDAD_MAXIMA){
                System.out.println("Bienvenido");
            }else{
                throw new edadException("Edad incorrecta");
            }
        } catch (edadException e) {
            if(e.getMessage() == null){
                System.out.println("Número Inválido ");   
            }else{
                System.out.println("Error: "+e.getMessage());   
            }            
        } catch(InputMismatchException w){
            System.out.println("Dato Inválido");
        }                
    }
    
}
