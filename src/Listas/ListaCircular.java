public class ListaCircular<T> {
    private NoCircular<T> sentinela;
    private int tamanho;

    public ListaCircular(){
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

    public void adicionarFim(T valor){
        NoCircular<T> novoNo = new NoCircular<T>(valor);
        NoCircular<T> ultimo = sentinela.getAnter();
        
        novoNo.setProx(sentinela);
        novoNo.setAnter(ultimo);
        ultimo.setProx(novoNo);
        sentinela.setAnter(novoNo);

        tamanho++;
    }

    public void adicionarInicio(T valor){
        NoCircular<T> novoNo = new NoCircular<T>(valor);
        NoCircular<T> primeiro = sentinela.getProx();

        novoNo.setProx(primeiro);
        novoNo.setAnter(sentinela);
        sentinela.setProx(novoNo);
        primeiro.setAnter(novoNo);

        tamanho++;
    }

    public T removerInicio(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
        }

        NoCircular<T> primeiro = sentinela.getProx();
        T valor = primeiro.getValor();

        sentinela.setProx(primeiro.getProx());
        primeiro.getProx().setAnter(sentinela);

        tamanho--;
        return valor;
    }

    public T removerFim(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
        }

        NoCircular<T> ultimo = sentinela.getAnter();
        T valor = ultimo.getValor();

        sentinela.setAnter(ultimo.getAnter());
        ultimo.getAnter().setProx(sentinela);

        tamanho--;
        return valor;
    }

    public void removerMeio(T valor){
        if(estaNaLista(valor) != true){
            System.out.println("O item buscado não existe.");
            return;
        }
        NoCircular<T> atual = sentinela.getProx();
        while(atual != sentinela){
            if(atual.getValor() == valor){
                atual.getAnter().setProx(atual.getProx());
                atual.getProx().setAnter(atual.getAnter());
                tamanho--;
                System.out.println("Item encontrado e removido da lista.");
                return;
            }
            atual = atual.getProx();
        }
    }

    public boolean estaNaLista(T valor){
        NoCircular<T> atual = sentinela.getProx();
        while(atual != sentinela){
            if(atual.getValor() == valor){
                return true;
            }
            atual = atual.getProx();
        }
        return false;
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
