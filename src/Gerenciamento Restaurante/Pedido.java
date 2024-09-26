public class Pedido {
    String descricao;
    int tamanho;
    double valor;
    
    public Pedido(String descricao, int tamanho, double valor) {
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;
    }
    
    public String getDescricao() {
        return descricao;
    }
   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
