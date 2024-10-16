public class Restaurante {
    private ListaDupla<Mesa> mesas;

    public Restaurante() {
        mesas = new ListaDupla<>();
    }

    public ListaDupla<Mesa> getMesas(){
        return mesas;
    }
    public void setMesas(ListaDupla<Mesa> mesas) {
        this.mesas = mesas;
    }

    public void registrarMesa(Mesa mesa) {
        if (mesa == null){
            System.out.println("Favor inserir os dados da mesa corretamente");
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

    public Mesa buscarMesa(Mesa numeroMesa){
        if(mesas.estaNaLista(numeroMesa)){
            NoDuplo<Mesa> atual = mesas.getPrimeiro();
            while(atual.getValor() != numeroMesa){
                atual = atual.getProx();
            }
            return atual.getValor();
        } else {
            System.out.println("Mesa não localizada.");
            return null;
        }
    }

    public Pedido buscarPedidoMesa(Mesa numeroMesa, Pedido pratoPedido) {
        if(mesas.estaNaLista(numeroMesa)){
            NoDuplo<Mesa> atual = mesas.getPrimeiro();
            while(atual.getValor() != numeroMesa){
                atual = atual.getProx();
            }
            ListaSimples<Pedido> pedidosdaMesa = atual.getValor().getPedidosdaMesa();
            if(pedidosdaMesa.estaNaLista(pratoPedido)){
                NoSimples<Pedido> atualPedido = pedidosdaMesa.getPrimeiro();
                while (atualPedido.getValor() != pratoPedido){
                    atualPedido = atualPedido.getProx();
                }
                return atualPedido.getValor();
            } else {
                System.out.println("Pedido não localizado.");
                return null;
            }
        } else {
            System.out.println("Mesa não localizada");
            return null;
        }
    }

    public void atualizarPedidoMesa(Mesa numeroMesa, Pedido pratoPedido, String novaDescricao, double novoValor) {
        Pedido atualização = buscarPedidoMesa(numeroMesa, pratoPedido);
        atualização.setDescricao(novaDescricao);
        atualização.setPreço(novoValor);
        NoDuplo<Mesa> atual = mesas.getPrimeiro();
        while(atual.getValor() != numeroMesa){
            atual = atual.getProx();
        }
        atual.getValor().getPedidosdaMesa().removerMeio(pratoPedido);
        atual.getValor().getPedidosdaMesa().adicionarInicio(atualização);
    }
}

