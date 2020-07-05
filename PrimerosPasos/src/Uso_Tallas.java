import java.util.*;

public class Uso_Tallas {
	
//	enum Talla {
//		MINI,
//		MEDIANO,
//		GRANDE,
//		MUY_GRANDE
//	};

	enum Talla{
		
		MINI("S"),
		MEDIANO("M"),
		GRANDE("L"),
		MUY_GRANDE("XL");
		
		private String abreviatura;
		
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
		public String dameAbreviatura() {
			return this.abreviatura;
		}
	}
	
	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escribe una talla (MINI, MEDIANO, GRANDE O MUY_GRANDE):");
		
		String entrada_datos = entrada.next().toUpperCase();
		
		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("La talla = "+la_talla);
		
		System.out.println("Abreviatura = "+la_talla.dameAbreviatura());
		
	}

}
