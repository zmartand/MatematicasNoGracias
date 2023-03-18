package org.example;

public class Nodo {
    private DatoPolinomio dato;
    private Nodo siguiente;

    public Nodo(DatoPolinomio dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public DatoPolinomio obtenerDato() {
        return this.dato;
    }

    public Nodo obtenerSiguiente() {
        return this.siguiente;
    }

    public void establecerSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
