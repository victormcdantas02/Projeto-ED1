public class NoDuplo<T> {
    private T valor;
    private NoDuplo<T> prox;
    private NoDuplo<T> anter;

    public NoDuplo(T valor, NoDuplo<T> prox, NoDuplo<T> anter){
        this.valor = valor;
        this.prox = null;
        this.anter = null;
    }

    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public NoDuplo<T> getProx() {
        return prox;
    }
    public void setProx(NoDuplo<T> prox) {
        this.prox = prox;
    }
    public NoDuplo<T> getAnter() {
        return anter;
    }
    public void setAnter(NoDuplo<T> anter) {
        this.anter = anter;
    }
    
}
