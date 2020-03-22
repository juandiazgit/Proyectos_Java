package apparreglo;

/**
 *
 * @author Ordenador
 */
public class AppArreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int [] arrelgo= new int[4];                
//        arrelgo[0]=1;
//        arrelgo[1]=2;
//        arrelgo[2]=3;
//        arrelgo[3]=4;
//        
//        System.out.println("Posición: "+arrelgo[arrelgo[arrelgo[0]]]);
//        System.out.println("Tamaño: "+arrelgo.length);

//        List lista=new ArrayList();
//        lista.add(55);
//        lista.add(77);
//        lista.add(44);
//        lista.add(53);
//        lista.add(12);
//        System.out.println("Tamaño: "+lista.size());
//        System.out.println("Posición: "+lista.get(3).toString());

//        int arreglo[]={1,2,3,4,5,6,7,8,9,10};
//        System.out.println(arreglo[arreglo[arreglo[5]]]);

//        System.out.println("Rta: "+metodorecu(5));
//        System.out.println("Suma: "+sumar());
//        System.out.println("metodoRar: "+metodoRar());        
        System.out.println("metodon: "+metodon(17));        
    }
    public static int metodon(int n){
        if(n==0){
            return n;
        }
        else
        {
            return metodon(n/10)+(n%10);
        }         
    }
//    public static int metodorecu(int valor){
//        if(valor < 3){
//            return valor;
//        }
//        return metodorecu(valor-1)*metodorecu(valor-2);
//    }            
//    public static String metodoRar(){        
//        int [] lista = {8,9,3};
//        int n = lista.length;
//        String[] simbolo = new String[n];
//        int i,j,aux,izq,der,m;
//        
//        for(i=1; i<n; i++){
//            aux = lista[i]; izq=0; der=i-1;
//            while(izq <= der){
//                m = ((izq+der)/2);
//                if(aux < lista[m]){
//                    der = m-1;
//                    simbolo[i-1]="-";
//                }
//                else
//                {
//                    izq = m+1;
//                    simbolo[i-1]="+";
//                }
//            }
//            j=i-1;
//            while(j >= izq){
//                lista[j+1]=lista[j];
//                j = j-1;
//            }
//            lista[izq]=aux;
//        }
//        simbolo[i-1] = "$";
//        String salida = "";
//        for(i=0; i<n; i++){
//            salida += lista[i]+simbolo[i];
//        }
//        return salida;
//    }
}
