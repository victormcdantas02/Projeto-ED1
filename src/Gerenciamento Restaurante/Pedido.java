public class Pedido {
    String descricao;
    int tamanho;
    double preço;
    
    public Pedido(String descricao, int tamanho, double preço) {
        this.descricao = descricao;
        this.tamanho = tamanho;
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
    
    public int getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
