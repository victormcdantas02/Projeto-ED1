public class NoSimples<T>{
    private T valor;
    private NoSimples<T> prox;

    public NoSimples(T valor, NoSimples<T> prox){
        this.valor = valor;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public NoSimples<T> getProx() {
        return prox;
    }
    public void setProx(NoSimples<T> prox) {
        this.prox = prox;
    }
    
}