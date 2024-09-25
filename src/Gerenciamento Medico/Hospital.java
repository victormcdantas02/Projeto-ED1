import java.util.List;

public class Hospital {
    private Medico medico;
    private List<Paciente> pacientes;
    private Consulta consulta;
    
    public Hospital(Medico medico, Paciente paciente, Consulta consulta) {
        this.medico = medico;
        this.pacientes = pacientes;
        this.consulta = consulta;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Paciente getPaciente() {
        return (Paciente) pacientes;
    }
    public void setPaciente(Paciente paciente) {
        this.pacientes = pacientes;
    }
    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public void inserirPaciente(Paciente novoPaciente) {
        if (novoPaciente == null) {
            System.out.println("Paciente não pode ser nulo.");
            return;
        }
        pacientes.add(novoPaciente); // Adiciona o novo paciente à lista
        System.out.println("Paciente " + novoPaciente.getNome() + " inserido com sucesso no hospital.");
    }
}
