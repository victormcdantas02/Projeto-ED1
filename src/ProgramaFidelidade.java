public class ProgramaFidelidade {
    private Pessoa cliente;
    private int pontosAtuais;
    private ListaSimples<Pedido> pedidosResgatados;
    
    public ProgramaFidelidade(Pessoa cliente) {
        this.cliente = cliente;
        this.pontosAtuais = 0;
        this.pedidosResgatados = new ListaSimples<>();
    }
    
    public void adicionarPonto() {
        pontosAtuais++;
        if (pontosAtuais == 10) {
            System.out.println("Parabéns! Você atingiu 10 pontos e ganhou um pedido grátis!");
            System.out.println("Use o método resgatarPedidoGratis() na sua próxima compra.");
        }
    }
    
    public boolean podeResgatarGratis() {
        return pontosAtuais >= 10;
    }
    
    public void resgatarPedidoGratis(Pedido pedido) {
        if (podeResgatarGratis()) {
            pedidosResgatados.adicionarInicio(pedido);
            pontosAtuais -= 10;
            System.out.println("Pedido grátis resgatado com sucesso!");
        } else {
            System.out.println("Pontos insuficientes para resgatar pedido grátis.");
            System.out.println("Pontos atuais: " + pontosAtuais);
        }
    }
    
    public int getPontosAtuais() {
        return pontosAtuais;
    }
    
    public ListaSimples<Pedido> getPedidosResgatados() {
        return pedidosResgatados;
    }
    
    public Pessoa getCliente() {
        return cliente;
    }
}