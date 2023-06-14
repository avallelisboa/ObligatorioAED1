/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TADS;

public class NodoCola<T extends Comparable> implements Comparable {
    public T valor;
    public NodoCola<T> siguiente;

    @Override
    public int compareTo(Object o) {
        T otroValor = ((NodoCola<T>)o).valor;
        return valor.compareTo(otroValor);
    } 
    
}