package SistemaAutogestion.Dominio.Entidades;

import TADS.Lista;
import TADS.Pila;

 
public class Cliente implements Comparable<Cliente> {

    public Cliente(String ci, String nombre){
        this.ci = ci;
        this.nombre = nombre;
    }
    public Cliente(String ci, String nombre, int tel) {
        this.ci = ci;
        this.nombre = nombre;
        this.tel = tel;
    }
    public Cliente(String ci, String nombre, int tel, Pila<Pedido> pedidos) {
        this.ci = ci;
        this.nombre = nombre;
        this.tel = tel;
        this.pedidos = pedidos;
    }
    private String ci;

    public Cliente(String ci) {
        this.ci = ci;
    }
    private String nombre;
    private int tel;
    private Pila<Pedido> pedidos = new Pila<Pedido>();    

    public Pila<Pedido> getPedidos() {
        return pedidos;
    }
    public void agregarPedido(Pedido p){
        pedidos.agregar(p);
    }
    
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    @Override
    public String toString(){
        return "* " + ci + ", nombre: " + nombre + ", tel: " + tel;
    }
    @Override
    public boolean equals(Object o){
        Cliente other = (Cliente)o;
        return this.ci.equals(other.ci);
    }
    @Override
    public int compareTo(Cliente o) {
        return this.nombre.compareTo(o.nombre);
    }
}
