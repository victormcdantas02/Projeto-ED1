public class Pedido {
    String descricao;
    int quantidade;
    double preço;
    
    public Pedido(String descricao, int quantidade, double preço) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preço = preço;
    }
    
    public String getDescricao() {
        return descricao;
    }
   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getPreço() {
        return preço;
    }
    
    public void setPreço(double preço) {
        this.preço = preço;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
