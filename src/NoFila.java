public class NoFila<T> {
    private T valor;
    private NoFila<T> prox;
    
    
    public NoFila(T valor) {
        this.valor = valor;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public NoFila<T> getProx() {
        return prox;
    }
    public void setProx(NoFila<T> prox) {
        this.prox = prox;
    }
}
