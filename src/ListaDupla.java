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

    public void adicionarFim(T valor){
        NoDuplo<T> novoNo = new NoDuplo<T>(valor);
        if(estaVazia()){
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProx(novoNo);
            novoNo.setAnter(ultimo);
            ultimo = novoNo;
        }
        tamanho++;
    }

    public void adicionarInicio(T valor){
        NoDuplo<T> novoNo = new NoDuplo<T>(valor);
        if(estaVazia()){
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            primeiro.setAnter(novoNo);
            novoNo.setProx(primeiro);
            primeiro = novoNo;
        }
        tamanho++;
    }

    public T removerFim(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
        }

        T valor = ultimo.getValor();
        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        } else {
            ultimo = ultimo.getAnter();
            ultimo.setProx(null);
        }
        tamanho--;
        return valor;
    }

    public T removerInicio(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
        }

        T valor = primeiro.getValor();
        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        } else {
            primeiro = primeiro.getProx();
            primeiro.setAnter(null);
        }
        tamanho--;
        return valor;
    }

    public void removerMeio(T valor){
        if(estaNaLista(valor) != true){
            System.out.println("O item buscado não existe.");
            return;
        }

        NoDuplo<T> atual = primeiro;
        while(atual != null){
            if(atual.getValor() == valor){
                atual.getAnter().setProx(atual.getProx());
                atual.getProx().setAnter(atual.getAnter());
                System.out.println("Item encontrado e removido da lista.");
            }
            atual = atual.getProx();
        }
    }

    public boolean estaNaLista(T valor){
        NoDuplo<T> atual = primeiro;
        while(atual != null){
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

        NoDuplo<T> atual = primeiro;
        while(atual.getProx() != null){
            System.out.println(atual.getValor());
            atual = atual.getProx();
        }
    }
}
