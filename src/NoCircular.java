public class NoCircular<T> {
    private T valor;
    private NoCircular<T> prox;
    private NoCircular<T> anter;

    public NoCircular(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public NoCircular<T> getProx() {
        return prox;
    }
    public void setProx(NoCircular<T> prox) {
        this.prox = prox;
    }
    public NoCircular<T> getAnter() {
        return anter;
    }
    public void setAnter(NoCircular<T> anter) {
        this.anter = anter;
    }
    
}
