public class ListaDupla<T> {
    private NoDuplo<T> primeiro;
    private NoDuplo<T> ultimo;
    private int tamanho;

    public ListaDupla(NoDuplo<T> primeiro, NoDuplo<T> ultimo, int tamanho){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public NoDuplo<T> getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(NoDuplo<T> primeiro) {
        this.primeiro = primeiro;
    }
    public NoDuplo<T> getUltimo() {
        return ultimo;
    }
    public void setUltimo(NoDuplo<T> ultimo) {
        this.ultimo = ultimo;
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
