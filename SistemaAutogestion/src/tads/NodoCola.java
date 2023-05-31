package tads;


public class NodoCola<T extends Comparable> implements Comparable {
    public T valor;
    public NodoCola<T> siguiente;

    @Override
    public int compareTo(Object o) {
        T otroValor = ((NodoCola<T>)o).valor;
        return valor.compareTo(otroValor);
    } 
    
}
