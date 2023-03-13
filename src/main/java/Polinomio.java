public class Polinomio extends DatoPolinomio implements Nodo {
    private Nodo termino_mayor;
    private int grado;

    public Polinomio() {
        super();
        this.termino_mayor = null;
        this.grado = -1;
    }

    @Override
    public DatoPolinomio getInfo() {
        return null;
    }

    @Override
    public void setInfo(DatoPolinomio info) {

    }

    @Override
    public Nodo getSig() {
        return null;
    }

    @Override
    public void setSig(Nodo sig) {

    }

    //Crea un polinomio de grado cero
    public void agregarTermino(int termino, int valor) {
        Nodo aux = new Nodo() {
            @Override
            public DatoPolinomio getInfo() {
                return null;
            }

            @Override
            public void setInfo(DatoPolinomio info) {
            }

            @Override
            public Nodo getSig() {
                return null;
            }

            @Override
            public void setSig(Nodo sig) {
            }
        };
        DatoPolinomio dato = new DatoPolinomio(valor, termino) {
            @Override
            public int getValor() {
                return 0;
            }

            @Override
            public void setValor(int valor) {
            }

            @Override
            public int getTermino() {
                return 0;
            }
        };
        if (this.termino_mayor == null) {
            this.termino_mayor = aux;
            aux.setInfo(dato);
            aux.setSig(null);
        } else {
            Nodo aux2 = this.termino_mayor;
            while (aux2.getSig() != null) {
                aux2 = aux2.getSig();
            }
            aux2.setSig(aux);
            aux.setInfo(dato);
            aux.setSig(null);
        }
        if (termino > this.grado) {
            this.grado = termino;
        }
    }

    //Modificar término
    public void modificarTermino(int termino, int valor) {
        Nodo aux = this.termino_mayor;
        while (aux != null) {
            if (aux.getInfo().getTermino() == termino) {
                aux.getInfo().setValor(valor);
            }
            aux = aux.getSig();
        }
    }

    //Obtener valor de un término del polinomio
    public int obtenerValor(int termino) {
        Nodo aux = this.termino_mayor;
        while (aux != null) {
            if (aux.getInfo().getTermino() == termino) {
                return aux.getInfo().getValor();
            }
            aux = aux.getSig();
        }
        return 0;
    }

    //Mostrar el polinomio
    public void mostrarPolinomio() {
        Nodo aux = this.termino_mayor;
        while (aux != null) {
            System.out.print(aux.getInfo().getValor() + "x^" + aux.getInfo().getTermino());
            if (aux.getSig() != null) {
                System.out.print(" + ");
            }
            aux = aux.getSig();
        }
        System.out.println();
    }

    //Sumar dos polinomios
    public Polinomio sumar(Polinomio p) {
        Polinomio resultado = new Polinomio();
        Nodo aux = this.termino_mayor;
        while (aux != null) {
            resultado.agregarTermino(aux.getInfo().getTermino(), aux.getInfo().getValor());
            aux = aux.getSig();
        }
        aux = p.termino_mayor;
        while (aux != null) {
            resultado.modificarTermino(aux.getInfo().getTermino(), resultado.obtenerValor(aux.getInfo().getTermino()) + aux.getInfo().getValor());
            aux = aux.getSig();
        }
        return resultado;
    }

    //Multiplicar dos polinomios
    public Polinomio multiplicar(Polinomio p) {
        Polinomio resultado = new Polinomio();
        Nodo aux = this.termino_mayor;
        while (aux != null) {
            Nodo aux2 = p.termino_mayor;
            while (aux2 != null) {
                resultado.modificarTermino(aux.getInfo().getTermino() + aux2.getInfo().getTermino(), resultado.obtenerValor(aux.getInfo().getTermino() + aux2.getInfo().getTermino()) + aux.getInfo().getValor() * aux2.getInfo().getValor());
                aux2 = aux2.getSig();
            }
            aux = aux.getSig();
        }
        return resultado;
    }
}