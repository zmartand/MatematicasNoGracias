public abstract class DatoPolinomio {
    private int valor;
    private int termino;
    public DatoPolinomio(int valor, int termino) {
        this.valor = valor;
        this.termino = termino;
    }

    public DatoPolinomio() {
    }
    //Crea un dato polinomio con valor y termino.
    public int getValor() {
        return valor;
    }
    public int getTermino() {
        return termino;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setTermino(int termino) {
        this.termino = termino;
    }


}
