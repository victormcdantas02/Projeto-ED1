public class ListaSimples<T> {
    private NoSimples<T> primeiro;
    private int tamanho;
    
    public ListaSimples() {
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
    
    public void adicionarInicio(T valor){
        NoSimples<T> novoNo = new NoSimples<T>(valor);
        novoNo.setProx(primeiro);
        primeiro = novoNo;
        tamanho++;
    }

    public void adicionarFim(T valor){
        NoSimples<T> novoNo = new NoSimples<T>(valor);
        if(estaVazia()){
            primeiro = novoNo;
        } else {
            NoSimples<T> atual = primeiro;
            while(atual.getProx() != null){
                atual = atual.getProx();
            }
            atual.setProx(novoNo);
        }
        tamanho++;
    }

    public T removerInicio(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
        }

        T valor = primeiro.getValor();
        primeiro = primeiro.getProx();

        tamanho--;
        return valor;
    }

    public T removerFim(){
        if(estaVazia()){
            System.out.println("A lista está vazia.");
        }

        if(primeiro.getProx() == null){
            T valor = primeiro.getValor();
            primeiro = null;
            tamanho--;
            return valor;
        }
        NoSimples<T> atual = primeiro;
        while(atual.getProx().getProx() != null){
            atual = atual.getProx();
        }
        T valor = atual.getProx().getValor();
        atual.setProx(null);
        tamanho--;
        return valor;
    }
    public void removerMeio(T valor){
        if(estaNaLista(valor) != true){
            System.out.println("O item buscado não existe.");
            return;
        }

        NoSimples<T> atual = primeiro;
        NoSimples<T> anterior = null;

        while(atual != null){
            if(atual.getValor() == valor){
                if(anterior == null){
                    primeiro = atual.getProx();
                } else {
                    anterior.setProx(atual.getProx());
                }
                tamanho--;
                System.out.println("Item encontrado e removido da lista.");
                return;
            }
            anterior = atual;
            atual = atual.getProx();
        }
    }

    public boolean estaNaLista(T valor){
        NoSimples<T> atual = primeiro;
        while(atual.getProx() != null){
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

        NoSimples<T> atual = primeiro;
        while(atual.getProx() != null){
            System.out.println(atual.getValor());
            atual = atual.getProx();
        }
    }
}
