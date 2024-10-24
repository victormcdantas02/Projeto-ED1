public class Pessoa {
    private String nome;
    private int idade;
    private String email;
    private String cpf;
    private ListaSimples<Pedido> historicoPedidos;
    private ListaDupla<Consulta> registroMedico;
    private ListaCircular<Evento> eventosParticipados;

    public Pessoa(String nome, int idade, String email, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        historicoPedidos = new ListaSimples<>();
        registroMedico = new ListaDupla<>();
        eventosParticipados = new ListaCircular<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public ListaSimples<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }
    public void setHistoricoPedidos(ListaSimples<Pedido> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }
    public ListaDupla<Consulta> getRegistroMedico() {
        return registroMedico;
    }
    public void setRegistroMedico(ListaDupla<Consulta> registroMedico) {
        this.registroMedico = registroMedico;
    }
    public ListaCircular<Evento> getEventosParticipados() {
        return eventosParticipados;
    }
    public void setEventosParticipados(ListaCircular<Evento> eventosParticipados) {
        this.eventosParticipados = eventosParticipados;
    }
    
    public void adicionarRegistro(Consulta novaConsulta){
        registroMedico.adicionarInicio(novaConsulta);
    }
    public void adicionarEventoParticipado(Evento novoEvento){
        eventosParticipados.adicionarInicio(novoEvento);
    }
    public void adicionarPedidoFeito(Pedido novoPedido){
        historicoPedidos.adicionarInicio(novoPedido);
    }
}
