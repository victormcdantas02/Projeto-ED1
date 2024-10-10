import java.util.Date;
public class Evento {
    private String nome;
    private Date diaDoEvento;
    private String local;
    private int capacidade;
    private ListaSimples<Participante> participantesEvento;
    private ListaSimples<Evento> eventos = new ListaSimples<>();
    
    
    public Evento(String nome, String local, int capacidade, Date diaDoEvento) {
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
        this.diaDoEvento = diaDoEvento;
        participantesEvento = new ListaSimples<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Date getDiaDoEvento() {
        return diaDoEvento;
    }

    public void setDiaDoEvento(Date diaDoEvento) {
        this.diaDoEvento = diaDoEvento;
    }
    
    public ListaSimples<Participante> getParticipantesEvento() {
        return participantesEvento;
    }

    public ListaSimples<Evento> getEventos() {
        return eventos;
    }

    public void registrarParticipante(Participante novoParticipante){
        if(novoParticipante == null){
            System.out.println("Por favor, insira os dados do participante corretamente.");
            return;
        }
        participantesEvento.adicionarInicio(novoParticipante);
        System.out.println("Novo participante registrado.");

    }

    public void cancelarInscrição(Participante inscriçãoACancelar){
        if(participantesEvento.estaNaLista(inscriçãoACancelar)){
            participantesEvento.removerMeio(inscriçãoACancelar);
            System.out.println("Inscrição cancelada.");
        } else {
            System.out.println("O participante não está inscrito neste evento");
        }

    }

    public Evento buscarEvento(Evento eventoAlvo){
        if(eventos.estaNaLista(eventoAlvo)){
            NoSimples<Evento> atual = eventos.getPrimeiro();
            while(atual.getValor() != eventoAlvo){
                atual = atual.getProx();
            }
            return atual.getValor();
        } else {
            System.out.println("Evento não localizado.");
            return null;
        }
    }

    public Participante buscarParticipante(Participante participante){
        Evento eventoInscrito = participante.getEvento();
        if(eventos.estaNaLista(eventoInscrito)){
            ListaSimples<Participante> listaEvento = buscarEvento(eventoInscrito).getParticipantesEvento();
            if(listaEvento.estaNaLista(participante)){
                NoSimples<Participante> atualParticipante = listaEvento.getPrimeiro();
                while(atualParticipante.getValor() != participante){
                    atualParticipante = atualParticipante.getProx();
                }
                return atualParticipante.getValor();
            } else {
                System.out.println("Participante não localizado.");
                return null;
            }
        } else {
            System.out.println("Evento não localizado");
            return null;
        }
    }

    public void atualizarEvento(Evento eventoAlvo, String novoNome, Date novoDia, String novoLocal, int novaCapacidade){
        Evento atualização = buscarEvento(eventoAlvo);
        atualização.setCapacidade(novaCapacidade);
        atualização.setDiaDoEvento(novoDia);
        atualização.setLocal(novoLocal);
        atualização.setNome(novoNome);
        
        eventos.removerMeio(eventoAlvo);
        eventos.adicionarInicio(atualização);
    }
    
}
