public class Cliente {
    private String nome;
    private int idade;
    private String email;
    private String cpf;
    private ListaSimples<Pedido> históricoPedidos;
    private ListaDupla<Consulta> registroMédico;
    private ListaCircular<Evento> eventosParticipados;

    public Cliente(String nome, int idade, String email, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        históricoPedidos = new ListaSimples<>();
        registroMédico = new ListaDupla<>();
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
    public ListaSimples<Pedido> getHistóricoPedidos() {
        return históricoPedidos;
    }
    public void setHistóricoPedidos(ListaSimples<Pedido> históricoPedidos) {
        this.históricoPedidos = históricoPedidos;
    }
    public ListaDupla<Consulta> getRegistroMédico() {
        return registroMédico;
    }
    public void setRegistroMédico(ListaDupla<Consulta> registroMédico) {
        this.registroMédico = registroMédico;
    }
    public ListaCircular<Evento> getEventosParticipados() {
        return eventosParticipados;
    }
    public void setEventosParticipados(ListaCircular<Evento> eventosParticipados) {
        this.eventosParticipados = eventosParticipados;
    }
    
    public void adicionarRegistro(Consulta novaConsulta){
        registroMédico.adicionarInicio(novaConsulta);
    }
    public void adicionarEventoParticipado(Evento novoEvento){
        eventosParticipados.adicionarInicio(novoEvento);
    }
    public void adicionarPedidoFeito(Pedido novoPedido){
        históricoPedidos.adicionarInicio(novoPedido);
    }
}
