package TADS;

public class Lista<T extends Comparable>{
    private NodoLista<T> primero;
    private NodoLista<T> ultimo;
    private int cantidad;
    
    public Lista(){
        cantidad = 0;
    }
    
    public boolean esVacia(){
        return cantidad == 0;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    private void _vaciar(){
        if(esVacia())
            return;
        NodoLista<T> aux = new NodoLista<T>();
        while(aux != null){
            aux = primero;
            borrarInicio();
        }
    }
    public void vaciar(){
        if(esVacia())
            return;
        if(cantidad == 1){
            borrarInicio();
            borrarFinal();
        }else
            _vaciar();            
    }
    private NodoLista<T> hacerNodo(T valor){
        NodoLista<T> nodo = new NodoLista<T>();
        nodo.valor = valor;
        return nodo;
    }
    private void _agregarInicioYFinal(NodoLista<T> nodo){
        primero = nodo;
        ultimo = nodo;
    }
    public void agregarInicio(T valor){
        NodoLista<T> nodo = hacerNodo(valor);
        if(esVacia())
            _agregarInicioYFinal(nodo);
        else{
            nodo.siguiente = primero;
            primero.anterior = nodo;
            primero = nodo;
        }
        cantidad++;
    }
    
    public void agregarOrdenado(T valor){
        NodoLista<T> nodoParaAgregar = new NodoLista();
        nodoParaAgregar.valor = valor;
        if(esVacia())
            _agregarInicioYFinal(nodoParaAgregar);
        else if(valor.compareTo(ultimo.valor) > 0)
            agregarFinal(valor);
        else if(valor.compareTo(primero.valor) < 0)
            agregarInicio(valor);
        else{
            NodoLista<T> aux = ultimo;
            while(valor.compareTo(aux.valor) < 0){
                aux = aux.anterior;
            }
            aux.siguiente.anterior = nodoParaAgregar;
            aux.siguiente = nodoParaAgregar;
        }
        cantidad++;
    }
    
    public void agregarFinal(T valor){
        NodoLista<T> nodo = hacerNodo(valor);
        if(esVacia())
            _agregarInicioYFinal(nodo);
        else{
            nodo.anterior = ultimo;
            ultimo.siguiente = nodo;
            ultimo = nodo;
        }
        cantidad++;
    }
    private void _borrarInicioYFinal(){
        primero.siguiente = null;
        primero = null;
        ultimo.anterior = null;
        ultimo = null;
    }
    public void borrarInicio(){
        if(esVacia())
            return;
        if(cantidad == 1)
            _borrarInicioYFinal();
        else{
            primero.siguiente.anterior = null;
            primero = primero.siguiente;
        }
        cantidad--;
    }
    public void borrarFinal(){
        if(esVacia())
            return;
        if(cantidad == 1)
            _borrarInicioYFinal();
        else{
            ultimo.anterior.siguiente = null;
            ultimo = ultimo.anterior;
        }
        if(cantidad > 0)
            cantidad--;
    }
    private void borrarElemento(NodoLista<T> nodo){
        nodo.anterior.siguiente = nodo.siguiente;
        nodo.siguiente.anterior = nodo.anterior;
    }
    private void _borrarPorValor(T valor){
        NodoLista<T> aux = new NodoLista<T>();
        aux = primero.siguiente;
        boolean fueEncontrado = false;
        while(aux != null && (!fueEncontrado)){
            if(aux.valor.equals(valor)){
                borrarElemento(aux);
                fueEncontrado = true;
            }
            aux = aux.siguiente;
        }
    }
    public void borrarPorValor(T valor){
        if(esVacia())
            return;
        if(primero.valor.equals(valor)){
            primero = primero.siguiente;
            cantidad--;
        }
        else if(ultimo.valor.equals(valor)){
            ultimo = ultimo.anterior;
            cantidad--;
        }
        else
            _borrarPorValor(valor);
    }
    
    public NodoLista<T> obtenerPorValor(T valor){
        if(esVacia())
            return null;
        if(valor == null)
            return null;
        if(valor.equals(primero.valor))
            return primero;
        if(valor.equals(ultimo.valor))
            return ultimo;
        
        NodoLista<T> aux = new NodoLista<T>();
        aux = primero.siguiente;
        while(aux != null){
            if(aux.valor.equals(valor))
                return aux;
            
            aux = aux.siguiente;
        }
        return null;
    }
    public boolean existe(T valor){
        if(cantidad == 0)
            return false;
        
        var nodo = obtenerPorValor(valor);
        return nodo != null;
    }
    
    public NodoLista<T> getPrimero() {
        return primero;
    }

    public NodoLista<T> getUltimo() {
        return ultimo;
    }
}