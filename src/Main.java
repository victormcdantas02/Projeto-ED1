import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public ListaSimples<Evento> eventos = new ListaSimples<>();
    public ListaCircular<Consulta> agendamentos = new ListaCircular<>();
    public static ListaCircular<Cliente> registroClientes = new ListaCircular<>();
    public static void main(String[] args) {
        
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
    public void registrarEvento(Evento novoEvento){
        if(novoEvento == null){
            System.out.println("Por favor, insira os dados do evento corretamente.");
        } else {
            eventos.adicionarInicio(novoEvento);
            System.out.println("Novo evento registrado.");
        }
    }
    public void agendarConsulta(Medico nomeMedico, Paciente nomePaciente, LocalDateTime dataHoraConsulta) {
        Consulta novaConsulta = new Consulta(nomePaciente, dataHoraConsulta, nomeMedico);
        agendamentos.adicionarInicio(novaConsulta);
        System.out.println("Consulta agendada para dia e hora " + dataHoraConsulta);
        NoCircular<Cliente> atual = Main.registroClientes.getSentinela().getProx();
        while(atual.getValor().getNome() != nomePaciente.getNome()){
            if(atual == Main.registroClientes.getSentinela()){
                break;
            }
            atual = atual.getProx();
        }
        if(atual == Main.registroClientes.getSentinela()){
            System.out.println("Cliente não encontrado");
        } else {
            atual.getValor().getRegistroMédico().adicionarInicio(novaConsulta);
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
    public void registrarCliente(Cliente novoCliente){
        if(novoCliente == null){
            System.out.println("Por favor, insira os dados do cliente corretamente.");
        } else {
            registroClientes.adicionarInicio(novoCliente);
            System.out.println("Novo cliente registrado.");
        }
    }
    public static Cliente buscarCliente(String nomeCliente){
        NoCircular<Cliente> atual = registroClientes.getSentinela().getProx();
        while(atual.getValor().getNome() != nomeCliente){
            if(atual == registroClientes.getSentinela()){
                break;
            }
            atual = atual.getProx();
        }
        if(atual == registroClientes.getSentinela()){
            System.out.println("Cliente não encontrado");
            return null;
        } else {
            return atual.getValor();
        }
    }

}
