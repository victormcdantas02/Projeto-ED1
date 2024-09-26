import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Mesa> mesas;

    public Restaurante() {
        mesas = new ArrayList<>();
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public Mesa buscarMesa(String numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero().equals(numero)) {
                return mesa;
            }
        }
        return null; 
    }

    public void adicionarPedido(String numeroMesa, Pedido item) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null) {
            mesa.adicionarPedido(item);
            System.out.println("Pedido adicionado à mesa " + numeroMesa);
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    public void fecharConta(String numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa != null) {
            double total = mesa.fecharConta();
            System.out.println("Total da conta da mesa " + numeroMesa + ": R$ " + total);
            mesa.setDisponibilidade(true); 
        } else {
            System.out.println("Mesa não encontrada.");
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

