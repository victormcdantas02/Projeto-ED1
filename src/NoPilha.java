public class NoPilha<T> {
    private T valor;
    private NoPilha<T> prox;
    
    
    public NoPilha(T valor) {
        this.valor = valor;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public NoPilha<T> getProx() {
        return prox;
    }
    public void setProx(NoPilha<T> prox) {
        this.prox = prox;
    }

}