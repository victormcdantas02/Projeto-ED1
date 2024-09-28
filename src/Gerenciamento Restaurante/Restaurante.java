public class Restaurante {
    private ListaDupla<Mesa> mesas;

    public Restaurante() {
        mesas = new ListaDupla<>();
    }

    public ListaDupla<Mesa> getMesas(){
        return mesas;
    }

    public void registrarMesa(Mesa mesa) {
        if (mesa == null){
            System.out.println("Favor inserir o número da mesa corretamente");
            return;
        }
        mesas.adicionarInicio(mesa);
        System.out.println("Mesa registrada com sucesso.");
    }

    public void fecharConta(Mesa numeroMesa) {
        if(mesas.estaNaLista(numeroMesa)){
            NoDuplo<Mesa> atual = mesas.getPrimeiro();
            while(atual.getValor() != numeroMesa){
                atual = atual.getProx();
            }
            double totalApagar = atual.getValor().calcularTotal();
            atual.getValor().setDisponibilidade(true);
            System.out.println("O total a pagar será R$" + totalApagar);
        }
    }

  
    public void buscarPedidoMesa(String numeroMesa, String descricaoPedido) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null) {
            Pedido pedido = mesa.buscarPedido(descricaoPedido);
            if (pedido != null) {
                System.out.println("Pedido encontrado: " + pedido.getItemPedido().getDescricao() + 
                                   " - R$ " + pedido.getItemPedido().getValor());
            } else {
                System.out.println("Pedido não encontrado.");
            }
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }


    public void atualizarPedidoMesa(String numeroMesa, String descricaoPedido, String novaDescricao, double novoValor) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null) {
            Pedido pedido = mesa.buscarPedido(descricaoPedido);
            if (pedido != null) {
                pedido.getItemPedido().setDescricao(novaDescricao);
                pedido.getItemPedido().setValor(novoValor);
                System.out.println("Pedido atualizado: " + novaDescricao + " - R$ " + novoValor);
            } else {
                System.out.println("Pedido não encontrado.");
            }
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }
}

