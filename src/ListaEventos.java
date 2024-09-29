public class ListaEventos {
    private Evento primeiro;

    public ListaEventos() {
        this.primeiro = null;
    }

    public void adicionarEvento(String nome, String data, String local, int capacidade) {
        Evento novoEvento = new Evento(nome, data, local, capacidade);
        novoEvento.proximo = primeiro;
        primeiro = novoEvento;
    }

    public boolean atualizarEvento(String nome, String novaData, String novoLocal, int novaCapacidade) {
        Evento atual = primeiro;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                atual.data = novaData;
                atual.local = novoLocal;
                atual.capacidade = novaCapacidade;
                return true;
            }
            atual = atual.proximo;
        }
        return false; 
    }

    public Evento buscarEvento(String nome) {
        Evento atual = primeiro;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null; 
    }
}
