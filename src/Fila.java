public class Fila<T> {
    private NoFila<T> começo;
    private NoFila<T> fim;
    private int tamanho;

    public Fila(){
        this.começo = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean isVazia(){
        return começo == null;
    }

    public int tamanho(){
        return tamanho;
    }

    public void adicionarFila(T valor){
        NoFila<T> novoNo = new NoFila<>(valor);
        if(isVazia()){
            começo = novoNo;
            fim = novoNo;
        } else {
            fim.setProx(novoNo);
            fim = novoNo;
        }
        tamanho+=1;
    }

    public T removerFila(){
        if(isVazia()){
            System.out.println("A pilha está vazia.");
        }
        T valor = começo.getValor();
        começo = começo.getProx();
        if(começo == null){
            fim = null;
        }
        tamanho-=1;
        return valor;
    }
    
    public T olharComeço(){
        if(isVazia()){
            System.out.println("A pilha está vazia.");
        }
        return começo.getValor();
    }
}
