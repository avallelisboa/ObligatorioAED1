package tads;

public class Pila<T extends Comparable> {
    private NodoPila<T> primero;
    private NodoPila<T> ultimo;
    private int cantidad;
    
    public Pila(){
        primero = null;
        ultimo = null;
        cantidad = 0;
    }
    public void agregar(T elemento) {
        NodoPila<T> nodo = new NodoPila<>();
        nodo.valor = elemento;
        if (estaVacia()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.siguiente = nodo;
            nodo.anterior = ultimo;
            ultimo = nodo;
        }
        cantidad++;
    }
    public void vaciar(){
        while(primero != null){
            quitar();
        }
    }
    
    public T quitar() {
        if (estaVacia())
            return null;
        
        T elemento = ultimo.valor;
        ultimo = ultimo.anterior;
        
        cantidad--;
        return elemento;
    }
    
    public T mirar() {
        if (estaVacia()) 
            return null;
        
        return ultimo.valor;
    }
    public NodoPila<T> GetNodoCabeza(){
        if (estaVacia()) 
            return null;
        
        return ultimo;
    }
    
    public boolean estaVacia() {
        return cantidad == 0;
    }

    public int getCantidad() {
        return cantidad;
    }
}
