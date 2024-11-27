public class Restaurante {
    private Arvore<ItemMenu> arvoreMenu; // Árvore binária para os itens do menu

    // Construtor
    public Restaurante() {
        this.arvoreMenu = null; // Inicializa a árvore como null
    }

    // Método para registrar um pedido (ou adicionar um item ao menu)
    public void registrarPedido(String nomeItem) {
        // Verifica se o item já existe no menu
        if (arvoreMenu == null) {
            // Se a árvore estiver vazia, cria a árvore com o primeiro item
            arvoreMenu = new Arvore<>(new ItemMenu(nomeItem), null, null);
        } else {
            // Se a árvore não estiver vazia, insere o item
            arvoreMenu.insert(new ItemMenu(nomeItem));
        }
    }

    // Método para consultar produtos populares
    public void consultarProdutosPopulares() {
        if (arvoreMenu == null) {
            System.out.println("Nenhum item no menu.");
        } else {
            // Aqui, pode-se adicionar a lógica para mostrar os itens populares
            // Exemplo: Percorrer a árvore e mostrar itens
            mostrarProdutosPopulares(arvoreMenu);
        }
    }

    // Método recursivo para percorrer a árvore e mostrar produtos populares
    private void mostrarProdutosPopulares(Arvore<ItemMenu> arvore) {
        if (arvore != null) {
            // Primeiro percorre a esquerda
            mostrarProdutosPopulares(arvore.getLeft());
            // Exibe o item e sua popularidade
            ItemMenu item = arvore.getValue();
            System.out.println(item.getNome() + " - Popularidade: " + item.getPopularidade());
            // Depois percorre a direita
            mostrarProdutosPopulares(arvore.getRight());
        }
    }

    // Método para atualizar a popularidade de um item
    public void aumentarPopularidade(String nomeItem) {
        if (arvoreMenu != null) {
            arvoreMenu.atualizarPopularidade(new ItemMenu(nomeItem));
        }
    }
}