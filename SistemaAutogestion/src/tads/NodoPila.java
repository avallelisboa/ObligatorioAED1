package tads;

public class NodoPila <T extends Comparable> implements Comparable{
    public T valor;
    public NodoPila<T> siguiente;
    public NodoPila<T> anterior;

    @Override
    public int compareTo(Object o) {
        T otroValor = ((NodoPila<T>)o).valor;
        return valor.compareTo(otroValor);
    } 
}
