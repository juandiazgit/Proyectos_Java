package Seleccion;

public class Masajista extends SeleccionFutbol {

	private String titulacion;
	private int aniosExperiencia;

	// constructor, getter y setter
	
	public Masajista(int id, String nombre, String apellidos, int edad, String titulacion, int aniosExperiencia) {
		super(id, nombre, apellidos, edad);
		this.titulacion = titulacion;
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public void entrenamiento() {
		System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
	}

	public void darMasaje() {
		System.out.println("Da un Masaje");
	}
}