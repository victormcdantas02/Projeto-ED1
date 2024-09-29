import java.time.LocalDateTime;

public class Consulta {
    private Paciente nomePaciente;
    private LocalDateTime diaConsulta;
    private Medico nomeMedico;
    private ListaCircular<Consulta> agendamentos;
    private ListaCircular<Paciente> registroPacientes;
    private ListaDupla<Medico> registroMedicos;
    
    public Consulta(Paciente nomePaciente, LocalDateTime diaConsulta, Medico nomeMedico) {
        this.nomePaciente = nomePaciente;
        this.diaConsulta = diaConsulta;
        this.nomeMedico = nomeMedico;
        agendamentos = new ListaCircular<>();
        registroPacientes = new ListaCircular<>();
        registroMedicos = new ListaDupla<>();
    }
    public Paciente getNomePaciente() {
        return nomePaciente;
    }
    public void setNomePaciente(Paciente nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
    public LocalDateTime getDiaConsulta() {
        return diaConsulta;
    }
    public void setDiaConsulta(LocalDateTime diaConsulta) {
        this.diaConsulta = diaConsulta;
    }
    public Medico getNomeMedico() {
        return nomeMedico;
    }
    public void setNomeMedico(Medico nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
    public ListaCircular<Consulta> getAgendamentos(){
        return agendamentos;
    }
    public ListaCircular<Paciente> getRegistroPacientes(){
        return registroPacientes;
    }
    public ListaDupla<Medico> getRegistroMedicos() {
        return registroMedicos;
    }

    public void registrarPaciente(Paciente novoRegistro){
        if (novoRegistro == null) {
            System.out.println("Por favor inserir os dados do paciente corretamente.");
            return;
        }
        registroPacientes.adicionarInicio(novoRegistro);
        System.out.println("Paciente " + novoRegistro.getNome() + " registrado com sucesso no hospital.");
    }

    public void agendarConsulta(Medico nomeMedico, Paciente nomePaciente, LocalDateTime dataHoraConsulta) {
        Consulta novaConsulta = new Consulta(nomePaciente, dataHoraConsulta, nomeMedico);
        agendamentos.adicionarInicio(novaConsulta);
        System.out.println("Consulta agendada para dia e hora " + dataHoraConsulta);
    }

    public Paciente buscarPaciente(Paciente registroAlvo){
        if(registroPacientes.estaNaLista(registroAlvo)){
            NoCircular<Paciente> atual = registroPacientes.getSentinela().getProx();
            while (atual.getValor() != registroAlvo){
                atual = atual.getProx();
            }
            return atual.getValor();
        } else {
            System.out.println("O registro buscado não existe.");
            return null;
        }
    }

    public Medico buscarMedico(Medico registroAlvo){
        if(registroMedicos.estaNaLista(registroAlvo)){
            NoDuplo<Medico> atual = registroMedicos.getPrimeiro();
            while (atual.getValor() != registroAlvo){
                atual = atual.getProx();
            }
            return atual.getValor();
        } else {
            System.out.println("O registro buscado não existe.");
            return null;
        }
    }

    public void atualizarConsulta(Paciente novoPaciente, Medico novoMedico, LocalDateTime novaDataHora, Consulta alvoAtualização){
        if(agendamentos.estaNaLista(alvoAtualização)){
            NoCircular<Consulta> atual = agendamentos.getSentinela().getProx();
            while(atual.getValor() != alvoAtualização){
                atual = atual.getProx();
            }
            atual.getValor().setNomePaciente(novoPaciente);
            atual.getValor().setDiaConsulta(novaDataHora);
            atual.getValor().setNomeMedico(novoMedico);
            System.out.println("Dados da consulta atualizados.");
        }
        return;
    }
}
