package org.example;

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

    public void modificarTermino(float valor, int termino) {
        Nodo nodoActual = this.terminoMayor;
        while (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() > termino) {
            nodoActual = nodoActual.obtenerSiguiente();
        }
        if (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() == termino) {
            nodoActual.obtenerDato().establecerValor(valor);
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
            Nodo nodoActualOtroPolinomio = polinomio.obtenerTerminoMayor();
            while (nodoActualOtroPolinomio != null) {
                float valor = nodoActual.obtenerDato().obtenerValor() * nodoActualOtroPolinomio.obtenerDato().obtenerValor();
                int termino = nodoActual.obtenerDato().obtenerTermino() + nodoActualOtroPolinomio.obtenerDato().obtenerTermino();
                resultado.cargarTermino(valor, termino);
                nodoActual = nodoActualOtroPolinomio.obtenerSiguiente();
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


    public void eliminarTermino(float valor, int termino) {
        if (this.terminoMayor == null) {
            return;
        }
        Nodo nodoActual = this.terminoMayor;
        Nodo nodoAnterior = null;
        while (nodoActual != null && nodoActual.obtenerDato().obtenerTermino() != termino) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.obtenerSiguiente();
        }
        if (nodoActual == null) {
            return;
        }
        if (nodoAnterior == null) {
            this.terminoMayor = nodoActual.obtenerSiguiente();
        } else {
            nodoAnterior.establecerSiguiente(nodoActual.obtenerSiguiente());
        }
        if (nodoActual.obtenerDato().obtenerTermino() == this.grado) {
            Nodo nodoActual2 = this.terminoMayor;
            int maxTermino = 0;
            while (nodoActual2 != null) {
                if (nodoActual2.obtenerDato().obtenerTermino() > maxTermino) {
                    maxTermino = nodoActual2.obtenerDato().obtenerTermino();
                }
                nodoActual2 = nodoActual2.obtenerSiguiente();
            }
            this.grado = maxTermino;
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


}




