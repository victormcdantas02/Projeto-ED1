public class Participante implements Comparable<Participante> {
    private String nome;
    private int numeroInscricao;
    private Evento evento;

    public Participante(String nome, int numeroInscricao, Evento evento) {
        this.nome = nome;
        this.numeroInscricao = numeroInscricao;
        this.evento = evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // Implementação do método compareTo
    @Override
    public int compareTo(Participante outroParticipante) {
        // Comparar com base no número de inscrição
        return Integer.compare(this.numeroInscricao, outroParticipante.numeroInscricao);
    }
}
