package Source;

/**
 *
 * @author Ordenador
 */
public class Elemento<T> {
    
    private T dato;

    public Elemento() {        
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}
