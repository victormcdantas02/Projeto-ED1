public class ListaCircular {
    //Definir o tipo do dado de sentinela como null no construtor depois que o tipo do nó da lista for definido
    NoCircular sentinela;
    int tamanho;

    public NoCircular getSentinela() {
        return sentinela;
    }
    public void setSentinela(NoCircular sentinela) {
        this.sentinela = sentinela;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public ListaCircular(int tamanho){
        this.tamanho = 0;
        sentinela = new NoCircular(sentinela, sentinela);
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public int tamanho(){
        return tamanho;
    }
}
