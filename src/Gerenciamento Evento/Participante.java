public class Participante {
    String nome;
    String numeroInscricao;
    Evento evento;

    public Participante(String nome, String numeroInscricao, Evento evento) {
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

    public String getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(String numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
