public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int tamanho;
    
    public NoDuplo getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(NoDuplo primeiro) {
        this.primeiro = primeiro;
    }
    public NoDuplo getUltimo() {
        return ultimo;
    }
    public void setUltimo(NoDuplo ultimo) {
        this.ultimo = ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public ListaDupla(NoDuplo primeiro, NoDuplo ultimo, int tamanho){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean estaVazia(){
        return primeiro == null;
    }

    public int tamanho(){
        return tamanho;
    }
}
