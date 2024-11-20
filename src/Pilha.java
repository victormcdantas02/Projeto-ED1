public class Pilha<T> {
    private NoPilha<T> top;
    private int tamanho;

    public Pilha() {
        this.top = null;
        this.tamanho = 0;
    }

    public boolean isVazia(){
        return top == null;
    }

    public int tamanho(){
        return tamanho;
    }

    public void adicionar(T valor){
        NoPilha<T> novoNo = new NoPilha<>(valor);
        novoNo.setProx(top);
        top = novoNo;
        tamanho++;
    }

    public T remover(){
        if(isVazia()){
            System.out.println("A pilha está vazia.");
        }
        T valor = top.getValor();
        top = top.getProx();
        tamanho--;
        return valor;
    }

    public T olharTop(){
        if(isVazia()){
            System.out.println("A pilha está vazia.");
        }
        return top.getValor();
    }
}
