import java.time.LocalDateTime;

public class Consulta {
    private Paciente nomePaciente;
    private LocalDateTime diaConsulta;
    private Medico nomeMedico;
    private ListaCircular<Paciente> registroPacientes = new ListaCircular<>();
    private ListaDupla<Medico> registroMedicos = new ListaDupla<>();
    private Pilha<String> historicoAcoes;
    
    public Consulta(Paciente nomePaciente, LocalDateTime diaConsulta, Medico nomeMedico) {
        this.nomePaciente = nomePaciente;
        this.diaConsulta = diaConsulta;
        this.nomeMedico = nomeMedico;
        this.historicoAcoes = new Pilha<>();
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
    public ListaCircular<Paciente> getRegistroPacientes(){
        return registroPacientes;
    }
    public void setRegistroPacientes(ListaCircular<Paciente> registroPacientes) {
        this.registroPacientes = registroPacientes;
    }
    public ListaDupla<Medico> getRegistroMedicos() {
        return registroMedicos;
    }
    public void setRegistroMedicos(ListaDupla<Medico> registroMedicos) {
        this.registroMedicos = registroMedicos;
    }

    public void registrarPaciente(Paciente novoRegistro){
        if (novoRegistro == null) {
            System.out.println("Por favor inserir os dados do paciente corretamente.");
            return;
        }
        registroPacientes.adicionarInicio(novoRegistro);
        System.out.println("Paciente " + novoRegistro.getNome() + " registrado com sucesso no hospital.");
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
    public void registrarAcao(String acao) {
        historicoAcoes.adicionar(acao);
    }
    
    public String desfazerUltimaAcao() {
        if(historicoAcoes.isVazia()) {
            return "Sem ações para desfazer";
        }
        return historicoAcoes.remover();
    }
}
