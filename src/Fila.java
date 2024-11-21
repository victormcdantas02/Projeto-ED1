public class Fila<T> {
    private NoFila<T> comeco;
    private NoFila<T> fim;
    private int tamanho;

    public Fila(){
        this.comeco = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean isVazia(){
        return comeco == null;
    }

    public int tamanho(){
        return tamanho;
    }

    public void adicionarFila(T valor){
        NoFila<T> novoNo = new NoFila<>(valor);
        if(isVazia()){
            comeco = novoNo;
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
        T valor = comeco.getValor();
        comeco = comeco.getProx();
        if(comeco == null){
            fim = null;
        }
        tamanho-=1;
        return valor;
    }
    
    public T olharComeco(){
        if(isVazia()){
            System.out.println("A pilha está vazia.");
        }
        return comeco.getValor();
    }
}
