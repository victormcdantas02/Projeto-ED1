public class ItemMenu implements Comparable<ItemMenu> {
    private String nome;
    private int popularidade;

    public ItemMenu(String nome) {
        this.nome = nome;
        this.popularidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPopularidade() {
        return popularidade;
    }

    // Aumenta a popularidade do item
    public void aumentarPopularidade() {
        popularidade++;
    }

    @Override
    public int compareTo(ItemMenu outro) {
        return this.nome.compareTo(outro.nome);
    }
}
