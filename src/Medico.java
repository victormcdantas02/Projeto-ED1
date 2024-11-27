public class Medico implements Comparable<Medico> {
    private String nome;
    private String especialidade;
    private boolean disponivel;

    public Medico(String nome, String especialidade, boolean disponivel) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponivel = disponivel;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Medico outroMedico) {
        // Comparar pelo nome do médico, que será o critério de comparação default
        return this.nome.compareTo(outroMedico.getNome());
    }
}