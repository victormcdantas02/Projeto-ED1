public class Participante {
    String nome;
    String numeroInscricao;

    public Participante(String nome, String numeroInscricao) {
        this.nome = nome;
        this.numeroInscricao = numeroInscricao;
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
}
