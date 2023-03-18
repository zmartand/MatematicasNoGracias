package org.example;

import java.util.Scanner;

public class Polinomio {
    private int grado;
    private Nodo terminoMayor;

    public Polinomio() {
        this.grado = 0;
        this.terminoMayor = null;
    }

    public int obtenerGrado() {
        return this.grado;
    }

    public Nodo obtenerTerminoMayor() {
        return this.terminoMayor;
    }

    public void establecerGrado(int grado) {
        this.grado = grado;
    }

    public void establecerTerminoMayor(Nodo terminoMayor) {
        this.terminoMayor = terminoMayor;
    }

    public void cargarTermino(float valor, int termino) {
        DatoPolinomio dato = new DatoPolinomio(valor, termino);
        Nodo nuevoNodo = new Nodo(dato);
        if (this.terminoMayor == null) {
            this.terminoMayor = nuevoNodo;
        } else {
            Nodo nodoActual = this.terminoMayor;
            Nodo nodoAnterior = null;
            while (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() > termino) {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.obtenerSiguiente();
            }
            if (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() == termino) {
                nodoActual.obtenerDato().establecerValor(valor);
            } else {
                nuevoNodo.establecerSiguiente(nodoActual);
                if (nodoAnterior == null) {
                    this.terminoMayor = nuevoNodo;
                } else {
                    nodoAnterior.establecerSiguiente(nuevoNodo);
                }
            }
        }
        if (termino > this.grado) {
            this.grado = termino;
        }
    }
    public void modificarTermino(int termino, float valor) {
        Nodo nodoActual = this.terminoMayor;
        boolean terminoEncontrado = false;
        while (nodoActual != null && !terminoEncontrado) {
            if (nodoActual.obtenerDato().obtenerTermino() == termino) {
                if (valor != 0) {
                    nodoActual.obtenerDato().establecerValor(valor);
                } else {
                    this.eliminarTermino(termino);
                }
                terminoEncontrado = true;
            }
            nodoActual = nodoActual.obtenerSiguiente();
        }
        if (!terminoEncontrado && valor != 0) {
            this.cargarTermino(valor, termino);
        }
    }
    public float obtenerValor(float x) {
        float resultado = 0;
        Nodo nodoActual = this.terminoMayor;
        while (nodoActual != null) {
            resultado += nodoActual.obtenerDato().obtenerValor();
            nodoActual = nodoActual.obtenerSiguiente();
        }
        return resultado;
    }
    public Polinomio sumar(Polinomio polinomio) {
        Polinomio resultado = new Polinomio();
        Nodo nodoActual = this.terminoMayor;
        Nodo nodoActualOtroPolinomio = polinomio.obtenerTerminoMayor();
        while (nodoActual != null && nodoActualOtroPolinomio != null) {
            if (nodoActual.obtenerDato().obtenerTermino() == nodoActualOtroPolinomio.obtenerDato().obtenerTermino()) {
                float valor = nodoActual.obtenerDato().obtenerValor() + nodoActualOtroPolinomio.obtenerDato().obtenerValor();
                resultado.cargarTermino(valor, nodoActual.obtenerDato().obtenerTermino());
                nodoActual = nodoActual.obtenerSiguiente();
                nodoActualOtroPolinomio = nodoActualOtroPolinomio.obtenerSiguiente();
            } else if (nodoActual.obtenerDato().obtenerTermino() > nodoActualOtroPolinomio.obtenerDato().obtenerTermino()) {
                resultado.cargarTermino(nodoActual.obtenerDato().obtenerValor(), nodoActual.obtenerDato().obtenerTermino());
                nodoActual = nodoActual.obtenerSiguiente();
            } else {
                resultado.cargarTermino(nodoActualOtroPolinomio.obtenerDato().obtenerValor(), nodoActualOtroPolinomio.obtenerDato().obtenerTermino());
                nodoActualOtroPolinomio = nodoActualOtroPolinomio.obtenerSiguiente();
            }
        }
        while (nodoActual != null) {
            resultado.cargarTermino(nodoActual.obtenerDato().obtenerValor(), nodoActual.obtenerDato().obtenerTermino());
            nodoActual = nodoActual.obtenerSiguiente();
        }
        while (nodoActualOtroPolinomio != null) {
            resultado.cargarTermino(nodoActualOtroPolinomio.obtenerDato().obtenerValor(), nodoActualOtroPolinomio.obtenerDato().obtenerTermino());
            nodoActualOtroPolinomio = nodoActualOtroPolinomio.obtenerSiguiente();
        }
        return resultado;
    }

    public Polinomio multiplicar(Polinomio polinomio) {
        Polinomio resultado = new Polinomio();
        Nodo nodoActual = this.terminoMayor;
        while (nodoActual != null) {
            Nodo nodoActualOtroPolinomio = polinomio.terminoMayor;
            while (nodoActualOtroPolinomio != null) {
                float valor = nodoActual.obtenerDato().obtenerValor() * nodoActualOtroPolinomio.obtenerDato().obtenerValor();
                int termino = nodoActual.obtenerDato().obtenerTermino() + nodoActualOtroPolinomio.obtenerDato().obtenerTermino();
                resultado.cargarTermino(valor, termino);
                nodoActualOtroPolinomio = nodoActualOtroPolinomio.obtenerSiguiente();
            }
            nodoActual = nodoActual.obtenerSiguiente();
        }
        return resultado;
    }

    public Polinomio restar(Polinomio polinomio) {
        Polinomio resultado = new Polinomio();
        Nodo nodoActual = this.terminoMayor;
        Nodo nodoActualOtroPolinomio = polinomio.obtenerTerminoMayor();
        while (nodoActual != null || nodoActualOtroPolinomio != null) {
            float valor;
            int termino;
            if (nodoActual == null || (nodoActualOtroPolinomio != null && nodoActualOtroPolinomio.obtenerDato().obtenerTermino() > nodoActual.obtenerDato().obtenerTermino())) {
                valor = -nodoActualOtroPolinomio.obtenerDato().obtenerValor();
                termino = nodoActualOtroPolinomio.obtenerDato().obtenerTermino();
                nodoActualOtroPolinomio = nodoActualOtroPolinomio.obtenerSiguiente();
            } else if (nodoActualOtroPolinomio == null || (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() > nodoActualOtroPolinomio.obtenerDato().obtenerTermino())) {
                valor = nodoActual.obtenerDato().obtenerValor();
                termino = nodoActual.obtenerDato().obtenerTermino();
                nodoActual = nodoActual.obtenerSiguiente();
            } else {
                valor = nodoActual.obtenerDato().obtenerValor() - nodoActualOtroPolinomio.obtenerDato().obtenerValor();
                termino = nodoActual.obtenerDato().obtenerTermino();
                nodoActual = nodoActual.obtenerSiguiente();
                nodoActualOtroPolinomio = nodoActualOtroPolinomio.obtenerSiguiente();
            }
            resultado.cargarTermino(valor, termino);
        }
        return resultado;
    }
    public void eliminarTermino(int termino) {
        if (this.terminoMayor == null) {
            return; // El polinomio está vacío, no hay términos que eliminar
        }

        Nodo nodoActual = this.terminoMayor;
        Nodo nodoAnterior = null;

        while (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() != termino) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.obtenerSiguiente();
        }

        if (nodoActual == null) {
            return; // El término a eliminar no se encontró en el polinomio
        }

        if (nodoAnterior == null) {
            this.terminoMayor = nodoActual.obtenerSiguiente(); // El término a eliminar es el primero del polinomio
        } else {
            nodoAnterior.establecerSiguiente(nodoActual.obtenerSiguiente()); // El término a eliminar está en medio o al final del polinomio
        }

        // Actualizar el grado del polinomio si el término a eliminar era el término de mayor grado
        if (nodoActual == this.terminoMayor) {
            Nodo nuevoTerminoMayor = this.terminoMayor.obtenerSiguiente();
            while (nuevoTerminoMayor != null && nuevoTerminoMayor.obtenerDato().obtenerValor() == 0) {
                nuevoTerminoMayor = nuevoTerminoMayor.obtenerSiguiente();
            }
            this.terminoMayor = nuevoTerminoMayor;
            if (nuevoTerminoMayor == null) {
                this.grado = 0;
            } else {
                this.grado = nuevoTerminoMayor.obtenerDato().obtenerTermino();
            }
        } else if (nodoActual.obtenerDato().obtenerTermino() == this.grado) {
            // Actualizar el grado del polinomio si el término a eliminar era el término de mayor grado
            this.grado = this.terminoMayor.obtenerDato().obtenerTermino();
        }
    }


    public boolean existeTermino(int termino) {
        Nodo nodoActual = this.terminoMayor;
        while (nodoActual != null) {
            if (nodoActual.obtenerDato().obtenerTermino() == termino) {
                return true;
            }
            nodoActual = nodoActual.obtenerSiguiente();
        }
        return false;
    }

    public void mostrar() {
        Nodo nodoActual = this.terminoMayor;
        while (nodoActual != null) {
            System.out.print(nodoActual.obtenerDato().obtenerValor() + "x^" + nodoActual.obtenerDato().obtenerTermino());
            if (nodoActual.obtenerSiguiente() != null) {
                System.out.print(" + ");
            }
            nodoActual = nodoActual.obtenerSiguiente();
        }
        System.out.println();
    }
    @Override
    public String toString() {
        Nodo nodoActual = this.terminoMayor;
        StringBuilder sb = new StringBuilder();
        while (nodoActual != null) {
            sb.append(nodoActual.obtenerDato().toString());
            nodoActual = nodoActual.obtenerSiguiente();
            if (nodoActual != null) {
                sb.append(" + ");
            }
        }
        return sb.toString();
    }
}




