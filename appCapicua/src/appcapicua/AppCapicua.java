package appcapicua;

/**
 *
 * @author Ordenador
 */
public class AppCapicua {
    
    public static  void validarCapicua(String palabra){
        
        char[] cadena = palabra.toCharArray();
        char[] cadena_inv = new char[cadena.length]; 
         
        int j=0;
        String inv_cadena;
         
        for (int i = cadena.length-1; i >= 0; i--) {
            cadena_inv[j]=cadena[i];
            j++;
        }
        
        inv_cadena=String.valueOf(cadena_inv);
        
        if(palabra.equalsIgnoreCase(inv_cadena)){
            System.out.println("La palabra '"+palabra+"' es capicua");
        }
        else{
            System.out.println("La palabra '"+palabra+"' no es capicua");
        }
    }
    
    public static void main(String[] args) {
        String palabra = "arenera";
        
        validarCapicua(palabra);
    }
}
