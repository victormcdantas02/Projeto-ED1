public class ListaCircular<T> {
    private NoCircular<T> sentinela;
    private int tamanho;

    public ListaCircular(int tamanho){
        this.tamanho = 0;
        sentinela = new NoCircular<T>(null);
        sentinela.setAnter(sentinela);
        sentinela.setProx(sentinela);
    }

    public NoCircular<T> getSentinela() {
        return sentinela;
    }
    public void setSentinela(NoCircular<T> sentinela) {
        this.sentinela = sentinela;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public int tamanho(){
        return tamanho;
    }

    public void adicionarFim(T dado){
        NoCircular<T> novoNo = new NoCircular<T>(dado);
        NoCircular<T> ultimo = sentinela.getAnter();
        
        novoNo.setProx(sentinela);
        novoNo.setAnter(ultimo);
        ultimo.setProx(novoNo);
        sentinela.setAnter(novoNo);

        tamanho++;
    }

    public void adicionarInicio(T dado){
        NoCircular<T> novoNo = new NoCircular<T>(dado);
        NoCircular<T> primeiro = sentinela.getProx();

        novoNo.setProx(primeiro);
        novoNo.setAnter(sentinela);
        sentinela.setProx(novoNo);
        primeiro.setAnter(novoNo);

        tamanho++;
    }

    public void exibirLista(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
            return;
        }

        NoCircular<T> atual = sentinela.getProx();
        while (atual != sentinela) {
            System.out.println(atual.getValor());
            atual = atual.getProx();
        }
    }
}
