import java.time.LocalDateTime;

public class Consulta {
    private String nomePaciente;
    private LocalDateTime diaConsulta;
    private String nomeMedico;
    private ListaCircular<Consulta> agendamentos;
    private ListaCircular<Paciente> registroPacientes;
    
    public Consulta(String nome, LocalDateTime diaConsulta, String nomeMedico) {
        this.nomePaciente = nome;
        this.diaConsulta = diaConsulta;
        this.nomeMedico = nomeMedico;
        agendamentos = new ListaCircular<>();
        registroPacientes = new ListaCircular<>();
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

    public ListaCircular<Consulta> getAgendamentos(){
        return agendamentos;
    }

    public ListaCircular<Paciente> getRegistroPacientes(){
        return registroPacientes;
    }

    public void registrarPaciente(Paciente novoRegistro){
        if (novoRegistro == null) {
            System.out.println("Por favor inserir os dados do paciente corretamente.");
            return;
        }
        registroPacientes.adicionarInicio(novoRegistro);
        System.out.println("Paciente " + novoRegistro.getNome() + " registrado com sucesso no hospital.");
    }

    public void agendarConsulta(String nomeMedico, String nomePaciente, LocalDateTime dataHoraConsulta) {
        this.nomeMedico = nomeMedico;
        this.nomePaciente = nomePaciente;
        this.diaConsulta = dataHoraConsulta;
        System.out.println("Consulta agendada com sucesso!");
    }
}
