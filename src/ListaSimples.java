public class ListaSimples<T> {
    private NoSimples<T> primeiro;
    private int tamanho;
    
    public ListaSimples(NoSimples<T> primeiro, int tamanho) {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public NoSimples<T> getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(NoSimples<T> primeiro) {
        this.primeiro = primeiro;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public boolean estaVazia(){
        return primeiro == null;
    }
    public int tamanho(){
        return tamanho;
    }
    
}
