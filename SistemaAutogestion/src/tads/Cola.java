package tads;

public class Cola<T extends Comparable> {
    private NodoCola<T> primero;
    private NodoCola<T> ultimo;
    private int cantidad;

    public Cola() {
        primero = null;
        ultimo = null;
        cantidad = 0;
    }

    public void agregar(T elemento) {
        NodoCola<T> nodo = new NodoCola<>();
        nodo.valor = elemento;
        if (estaVacia()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.siguiente = nodo;
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
        
        T elemento = primero.valor;
        primero = primero.siguiente;
        
        cantidad--;
        return elemento;
    }

    public T mirar() {
        if (estaVacia()) 
            return null;
        
        return primero.valor;
    }
    
    public NodoCola<T> GetPrimerNodo(){
        if (estaVacia()) 
            return null;
        
        return primero;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public int getCantidad() {
        return cantidad;
    }
}
