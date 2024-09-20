public class ListaSimples {
    private NoSimples primeiro;
    private int tamanho;
    
    public ListaSimples(NoSimples primeiro, int tamanho) {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public NoSimples getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(NoSimples primeiro) {
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
