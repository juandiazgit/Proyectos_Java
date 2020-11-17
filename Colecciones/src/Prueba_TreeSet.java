import java.util.Comparator;
import java.util.TreeSet;

public class Prueba_TreeSet {
	
	public static void main(String[] args) {

//		TreeSet<String> ordenaPersonas = new TreeSet<String>();
//		
//		ordenaPersonas.add("Sandra");
//		ordenaPersonas.add("Amanda");
//		ordenaPersonas.add("Diana");
//		
//		for (String s : ordenaPersonas) {
//			System.out.println(s);
//		}
		
		Articulo primero = new Articulo(1, "Primer artículo");
		Articulo segundo = new Articulo(200, "Segundo artículo");
		Articulo tercer = new Articulo(3, "Este es el tercer artículo");
		
		TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
		
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		
		for (Articulo art : ordenaArticulos) {
			System.out.println(art.getDescripcion());
		}
		
		//////////////////////Ordenado alfabeticamente////////////////////////
		
//		Articulo comparadorArticulo = new Articulo();
//		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulo);
		
//		ComparadorArticulos compara_art = new ComparadorArticulos();
		
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() {

			@Override
			public int compare(Articulo o1, Articulo o2) {
				String desc1 = o1.getDescripcion();
				String desc2 = o2.getDescripcion();
				
				return desc1.compareTo(desc2);
			}
			
		});
		
		ordenaArticulos2.add(tercer);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		
		System.out.println("\n------Ordenado alfabeticamente--------");
		for (Articulo art : ordenaArticulos2) {
			System.out.println(art.getDescripcion());
		}

	}

}

class Articulo implements Comparable<Articulo>{

	private int numero_articulo;
	private String descripcion;
	
	public Articulo(int num, String desc) {
		
		this.numero_articulo = num;
		this.descripcion = desc;
		
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	@Override
	public int compareTo(Articulo o) {

		return this.numero_articulo - o.numero_articulo;
		
	}
	
}

