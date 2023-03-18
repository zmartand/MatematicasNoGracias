package org.example;

public class DatoPolinomio {
    private float valor;
    private int termino;

    public DatoPolinomio(float valor, int termino) {
        this.valor = valor;
        this.termino = termino;
    }

    public float obtenerValor() {
        return this.valor;
    }

    public int obtenerTermino() {
        return this.termino;
    }

    public void establecerValor(float valor) {
        this.valor = valor;
    }

    public void establecerTermino(int termino) {
        this.termino = termino;
    }

    public String toString() {
        return this.valor + "*x^" + this.termino;
    }
}

