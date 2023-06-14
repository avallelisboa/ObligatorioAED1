
package SistemaAutogestion.Dominio.Entidades;

import TADS.Lista;
import TADS.Pila;

public class Pedido implements Comparable{
    private int nroPedido;
    private Cliente cliente;
    private boolean estaCerrado;
    private boolean estaListoParaEntregar;
    private Pila<Producto> productos;
    private int unidades;

    public Pedido(int nroP) {
        this.nroPedido = nroP;
        this.estaCerrado = false;
        this.estaListoParaEntregar = false;
        this.productos = new Pila<Producto>();
        this.unidades = 0;
    }
    public Pedido(int nroP, Cliente cliente) {
        this.nroPedido = nroP;
        this.estaCerrado = false;
        this.estaListoParaEntregar = false;
        this.cliente = cliente;
        this.productos = new Pila<Producto>();
        this.unidades = 0;
    }

    public Pila<Producto> getProductos() {
        return productos;
    }    

    public int getNroPedido() {
        return nroPedido;
    }
    public Cliente getCiCliente() {
        return cliente;
    }

    public void setCiCliente(String ciCliente) {
        this.cliente = cliente;
    }
    
    public boolean getEstaCerrado(){
        return estaCerrado;
    }
    public void cerrarPedido(){
        estaCerrado = true;
    }
    
    public boolean getEstaListoParaEntregar(){
        return estaListoParaEntregar;
    }
    public void setListoParaEntregar(){
        estaListoParaEntregar = true;
    }
    
    public int getUnidades() {
        return this.unidades;
    }
    public void agregarProducto(Producto p){
        productos.agregar(p);
        this.unidades++;
    }
    public void quitarNProductos(int n){
        var auxNodoProducto = productos.GetNodoCabeza();
        int accionesRealizadas = 0;
        while(auxNodoProducto != null && accionesRealizadas < n){ 
            auxNodoProducto = auxNodoProducto.anterior;
            productos.quitar();
            accionesRealizadas++;
            
            this.unidades--;
        }
    }
    @Override
    public String toString(){
        String base = "* número de pedido: " + nroPedido + ", nombre: " + cliente.getNombre() + ", unidades totales: " + productos.getCantidad() + "\n";
        String productosReporte = "";
        String reporteFinal;
        var nodoProducto = productos.GetNodoCabeza();
        while(nodoProducto != null){
            productosReporte += nodoProducto.toString() + "\n";
            nodoProducto = nodoProducto.anterior;
        }
        reporteFinal = base + productosReporte;
        return reporteFinal;
    }
    @Override
    public boolean equals(Object o){
        Pedido p = (Pedido)o;
        int otherId = p.nroPedido;
        return this.nroPedido == otherId;
    }
    @Override
    public int compareTo(Object o) {
       int otherNro = ((Pedido)o).getNroPedido();
       if(nroPedido == otherNro)
           return 0;
       else if(nroPedido < otherNro)
           return -1;
       else
           return 1;
    }    
}