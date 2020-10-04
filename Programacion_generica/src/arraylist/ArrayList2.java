package arraylist;

public class ArrayList2 {
	
	private Object[] datosElementos;
	private int i = 0;

	public ArrayList2(int z) {
		datosElementos = new Object[z];
	}
	
	public Object get(int i) {
		return datosElementos[i];
	}
	
	public void add(Object o) {
		datosElementos[i] = o;
		i++;
	}

}
