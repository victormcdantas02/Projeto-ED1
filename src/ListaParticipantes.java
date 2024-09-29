public class ListaParticipantes {
    private Participante primeiro;

    public ListaParticipantes() {
        this.primeiro = null;
    }
    public void registrarParticipante(String nome, int numeroInscricao, String evento) {
        Participante novoParticipante = new Participante(nome, numeroInscricao, evento);
        novoParticipante.proximo = primeiro;
        primeiro = novoParticipante;
    }
    public boolean cancelarInscricao(int numeroInscricao) {
        Participante atual = primeiro;
        Participante anterior = null;

        while (atual != null) {
            if (atual.numeroInscricao == numeroInscricao) {
                if (anterior == null) {
                    primeiro = atual.proximo; 
                } else {
                    anterior.proximo = atual.proximo; 
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false; 
    }
    public Participante buscarParticipante(String nome) {
        Participante atual = primeiro;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null; 
    }
}
