package poo;

public class Coche {
	
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
	}
	
	public String dime_datos_generales() {
		
		return "\nLa plataforma tiene"
				+ "\nRuedas: "+ruedas+
				"\nLargo: "+largo+
				"\nAncho: "+ancho+
				"\nPeso Platafor: "+peso_plataforma;
	}
	
	public void establece_color(String color_coche) {
		color = color_coche;
	}
	
	public String dime_color() {
		return "Color del Coche: "+color;
	}
	
	public void configura_asientos(String asientos_cuero) {
		
		if (asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero = true;
		} else {
			this.asientos_cuero = false;
		}
	}
	
	public String dime_asientos() {
		
		if (this.asientos_cuero == true) {
			return "El coche tiene asientos de cuero.";
		} else {
			return "El coche tiene asientos de serie.";
		}
	}
	
	public void configura_climatizador(String climatizador) {
		
		if (climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		} else {
			this.climatizador = false;
		}
	}
	
	public String dime_climatizador() {
		
		if (this.climatizador == true) {
			return "El coche incorpora climatizador.";
		} else {
			return "El coche incorpora aire acondicionado.";
		}
	}
	
	public String dime_peso_coche() {
		
		int peso_carroceria = 500;
		this.peso_total = this.peso_plataforma + peso_carroceria;
		
		if (this.asientos_cuero) {
			this.peso_total = this.peso_total + 50;
		}
		
		if (this.climatizador) {
			this.peso_total = this.peso_total + 20;
		}
		
		return "El peso del coche es: "+this.peso_total;
	}
	
	public int precio_coche() {
		
		int precio_final = 10000;
		
		if (this.asientos_cuero) {
			precio_final += 2000;
		}
		
		if (this.climatizador) {
			precio_final += 1500;
		}
		
		return precio_final;
	}

}
