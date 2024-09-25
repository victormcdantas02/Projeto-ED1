import java.time.LocalDateTime;

public class Consulta {
    private String nomePaciente;
    private LocalDateTime diaConsulta;
    private String nomeMedico;
    
    public Consulta(String nome, LocalDateTime diaConsulta, String nomeMedico) {
        this.nomePaciente = nome;
        this.diaConsulta = diaConsulta;
        this.nomeMedico = nomeMedico;
    }
    public String getNome() {
        return nomePaciente;
    }
    public void setNome(String nome) {
        this.nomePaciente = nome;
    }
    public LocalDateTime getDiaConsulta() {
        return diaConsulta;
    }
    public void setDiaConsulta(LocalDateTime diaConsulta) {
        this.diaConsulta = diaConsulta;
    }
    public String getNomeMedico() {
        return nomeMedico;
    }
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void agendarConsulta(String nomeMedico, String nomePaciente, LocalDateTime dataHoraConsulta) {
        this.nomeMedico = nomeMedico;
        this.nomePaciente = nomePaciente;
        this.diaConsulta = dataHoraConsulta;
        System.out.println("Consulta agendada com sucesso!");
    }
}
