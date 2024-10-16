public class Mesa {
    private String numero;
    private boolean disponibilidade;
    private String cliente;
    private ListaSimples<Pedido> pedidosdaMesa;

    public Mesa(String numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.disponibilidade = true;
        pedidosdaMesa = new ListaSimples<>();
    }
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    public ListaSimples<Pedido> getPedidosdaMesa() {
        return pedidosdaMesa;
    }

    public void setPedidosdaMesa(ListaSimples<Pedido> pedidosdaMesa){
        this.pedidosdaMesa = pedidosdaMesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void adicionarPedidos(Pedido item){
        pedidosdaMesa.adicionarInicio(item);
        System.out.println("Pedido registrado.");
        NoCircular<Cliente> atual = Main.registroClientes.getSentinela().getProx();
        while(atual.getValor().getNome() != cliente){
            if(atual == Main.registroClientes.getSentinela()){
                break;
            }
            atual = atual.getProx();
        }
        if(atual == Main.registroClientes.getSentinela()){
            System.out.println("Cliente não encontrado");
        } else {
            atual.getValor().getHistóricoPedidos().adicionarInicio(item);
        }
    }

    public double calcularTotal(){
        if(pedidosdaMesa.getTamanho() == 0){
            System.out.println("A mesa não possui pedidos.");
            return 0;
        }
        NoSimples<Pedido> atual = pedidosdaMesa.getPrimeiro();
        double total = 0;
        while (atual != null){
            total = total + atual.getValor().getPreço();
            atual = atual.getProx();
        }
        ListaSimples<Pedido> novoRegistro = new ListaSimples<>();
        pedidosdaMesa = novoRegistro;
        return total;
    }
}
