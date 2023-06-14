/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TADS;

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