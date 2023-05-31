package tads;

public class NodoLista<T extends Comparable> implements Comparable {
    public T valor;
    public NodoLista<T> siguiente;
    public NodoLista<T> anterior;

    @Override
    public int compareTo(Object o) {
        T otroValor = ((NodoLista<T>)o).valor;
        return valor.compareTo(otroValor);
    }
}