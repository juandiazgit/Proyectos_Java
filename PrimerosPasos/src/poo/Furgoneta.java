package poo;

public class Furgoneta extends Coche{
	
	private int capacidad_carga;
	private int plazas_extra;
	
	public Furgoneta(int capacidad_carga, int plazas_extra) {
		super(); //Invocar el contructor de la clase padre o superclase "Coche".
		this.capacidad_carga = capacidad_carga;
		this.plazas_extra = plazas_extra;
	}
	
	public String dimeDatosFurgoneta() {
		return "Capacidad carga: "+this.capacidad_carga+", las plazas son: "+this.plazas_extra;
	}
	
}
