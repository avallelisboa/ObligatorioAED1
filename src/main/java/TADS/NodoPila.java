/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TADS;

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