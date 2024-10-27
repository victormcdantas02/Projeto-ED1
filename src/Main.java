import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public ListaSimples<Evento> eventos = new ListaSimples<>();
    public ListaCircular<Consulta> agendamentos = new ListaCircular<>();
    public static ListaCircular<Pessoa> registroPessoas = new ListaCircular<>();
    public static void main(String[] args) {
         Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Registrar Pessoa");
            System.out.println("2. Registrar Evento");
            System.out.println("3. Adicionar Participante a um Evento");
            System.out.println("4. Agendar Consulta");
            System.out.println("5. Adicionar Pedido em uma Mesa");
            System.out.println("6. Fechar Conta de uma Mesa");
            System.out.println("7. Consultar Pontos de Fidelidade");
            System.out.println("8. Resgatar Pedido Grátis");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome:");
                    String nomePessoa = scanner.nextLine();
                    System.out.println("Idade:");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Email:");
                    String email = scanner.nextLine();
                    System.out.println("CPF:");
                    String cpf = scanner.nextLine();
                    Pessoa novoPessoa = new Pessoa(nomePessoa, idade, email, cpf);
                    main.registrarPessoa(novoPessoa);
                    break;

                case 2:
                    System.out.println("Nome do Evento:");
                    String nomeEvento = scanner.nextLine();
                    System.out.println("Local do Evento:");
                    String local = scanner.nextLine();
                    System.out.println("Capacidade do Evento:");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Data do Evento (dd/MM/yyyy):");
                    String dataEvento = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate diaEvento = LocalDate.parse(dataEvento, formatter);
                    Evento novoEvento = new Evento(nomeEvento, local, capacidade, java.sql.Date.valueOf(diaEvento));
                    main.registrarEvento(novoEvento);
                    break;

                case 3:
                    System.out.println("Nome do Participante:");
                    String nomeParticipante = scanner.nextLine();
                    System.out.println("Número de Inscrição:");
                    int numeroInscricao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nome do Evento para Participação:");
                    String eventoParaParticipar = scanner.nextLine();
                    Evento evento = main.buscarEvento(new Evento(eventoParaParticipar, "", 0, new java.util.Date()));
                    if (evento != null) {
                        Participante novoParticipante = new Participante(nomeParticipante, numeroInscricao, evento);
                        main.adicionarRegistroEvento(novoParticipante, evento);
                    }
                    break;

                case 4:
                    System.out.println("Nome do Paciente:");
                    String nomePaciente = scanner.nextLine();
                    System.out.println("Idade do Paciente:");
                    int idadePaciente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Histórico Médico do Paciente:");
                    String historico = scanner.nextLine();
                    System.out.println("Nome do Médico:");
                    String nomeMedico = scanner.nextLine();
                    System.out.println("Especialidade do Médico:");
                    String especialidade = scanner.nextLine();
                    System.out.println("Data e Hora da Consulta (dd/MM/yyyy HH:mm):");
                    String dataHoraConsulta = scanner.nextLine();
                    LocalDateTime dataConsulta = LocalDateTime.parse(dataHoraConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                    Paciente novoPaciente = new Paciente(nomePaciente, idadePaciente, historico, new java.util.Date());
                    Medico medico = new Medico(nomeMedico, especialidade, true);
                    main.agendarConsulta(medico, novoPaciente, dataConsulta);
                    break;

                case 5:
                    System.out.println("Número da Mesa:");
                    String numeroMesa = scanner.nextLine();
                    System.out.println("Nome do Cliente:");
                    String clienteMesa = scanner.nextLine();
                    System.out.println("Descrição do Pedido:");
                    String descricaoPedido = scanner.nextLine();
                    System.out.println("Quantidade:");
                    int quantidadePedido = scanner.nextInt();
                    System.out.println("Preço:");
                    double precoPedido = scanner.nextDouble();
                    Mesa mesa = new Mesa(numeroMesa, clienteMesa);
                    Pedido pedido = new Pedido(descricaoPedido, quantidadePedido, precoPedido);
                    mesa.adicionarPedidos(pedido);
                    break;

                case 6:
                    System.out.println("Número da Mesa:");
                    String mesaNumero = scanner.nextLine();
                    Mesa mesaParaFechar = new Mesa(mesaNumero, "");
                    main.fecharConta(mesaParaFechar);
                    break;

                case 7:
                    System.out.println("Digite o nome do cliente para consultar os pontos:");
                    String nomeClientePontos = scanner.nextLine();
                    Pessoa clientePontos = buscarPessoa(nomeClientePontos);
                    if (clientePontos != null) {
                        main.gerarRelatorioFidelidade(clientePontos);
                    }
                    break;

                case 8:
                    System.out.println("Digite o nome do cliente:");
                    String nomeClienteResgate = scanner.nextLine();
                    System.out.println("Descrição do Pedido a ser resgatado:");
                    String descricaoResgate = scanner.nextLine();
                    System.out.println("Quantidade:");
                    int quantidadeResgate = scanner.nextInt();
                    System.out.println("Preço original (para registro):");
                    double precoResgate = scanner.nextDouble();
                    Pessoa clienteResgate = buscarPessoa(nomeClienteResgate);
                    if (clienteResgate != null) {
                        if (clienteResgate.getFidelidade().podeResgatarGratis()) {
                            Pedido pedidoResgate = new Pedido(descricaoResgate, quantidadeResgate, precoResgate);
                            clienteResgate.getFidelidade().resgatarPedidoGratis(pedidoResgate);
                        } else {
                            System.out.println("Cliente não possui pontos suficientes para resgate.");
                            System.out.println("Pontos atuais: " + clienteResgate.getFidelidade().getPontosAtuais());
                            System.out.println("Pontos necessários: 10");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
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
        NoCircular<Pessoa> atual = Main.registroPessoas.getSentinela().getProx();
        while(atual.getValor().getNome() != nomePaciente.getNome()){
            if(atual == Main.registroPessoas.getSentinela()){
                break;
            }
            atual = atual.getProx();
        }
        if(atual == Main.registroPessoas.getSentinela()){
            System.out.println("Pessoa não encontrado");
        } else {
            atual.getValor().getRegistroMedico().adicionarInicio(novaConsulta);
        }
    }
    public void atualizarConsulta(Paciente novoPaciente, Medico novoMedico, LocalDateTime novaDataHora, Consulta alvoAtualizacao){
        if(agendamentos.estaNaLista(alvoAtualizacao)){
            NoCircular<Consulta> atual = agendamentos.getSentinela().getProx();
            while(atual.getValor() != alvoAtualizacao){
                atual = atual.getProx();
            }
            atual.getValor().setNomePaciente(novoPaciente);
            atual.getValor().setDiaConsulta(novaDataHora);
            atual.getValor().setNomeMedico(novoMedico);
            System.out.println("Dados da consulta atualizados.");
        }
        return;
    }
    public void registrarPessoa(Pessoa novoPessoa){
        if(novoPessoa == null){
            System.out.println("Por favor, insira os dados do Pessoa corretamente.");
        } else {
            registroPessoas.adicionarInicio(novoPessoa);
            System.out.println("Novo Pessoa registrado.");
        }
    }
    public static Pessoa buscarPessoa(String nomePessoa){
        NoCircular<Pessoa> atual = registroPessoas.getSentinela().getProx();
        while(atual.getValor().getNome() != nomePessoa){
            if(atual == registroPessoas.getSentinela()){
                break;
            }
            atual = atual.getProx();
        }
        if(atual == registroPessoas.getSentinela()){
            System.out.println("Pessoa não encontrado");
            return null;
        } else {
            return atual.getValor();
        }
    }
    
    public void adicionarRegistroEvento(Participante participanteNovo, Evento eventoParticipado){
        eventoParticipado = buscarEvento(eventoParticipado);
        eventoParticipado.registrarParticipante(participanteNovo);
        NoCircular<Pessoa> atual = registroPessoas.getSentinela().getProx();
        while(atual.getValor().getNome() != participanteNovo.getNome()){
            if(atual == registroPessoas.getSentinela()){
                break;
            }
            atual = atual.getProx();
        }
        if(atual == Main.registroPessoas.getSentinela()){
            System.out.println("Pessoa não encontrado");
        } else {
            atual.getValor().getEventosParticipados().adicionarInicio(eventoParticipado);
        }
    }

        
        public void fecharConta(Mesa numeroMesa) {
        double totalApagar = numeroMesa.calcularTotal();
        numeroMesa.setDisponibilidade(true);
        System.out.println("O total a pagar será R$" + totalApagar);
    }


    public void gerarRelatorioFidelidade(Pessoa cliente) {
        System.out.println("\n=== Relatório de Fidelidade ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Pontos atuais: " + cliente.getFidelidade().getPontosAtuais());
        System.out.println("Pedidos grátis resgatados: " + 
                          cliente.getFidelidade().getPedidosResgatados().getTamanho());
        
        System.out.println("\nHistórico de Pedidos Grátis:");
        NoSimples<Pedido> atual = cliente.getFidelidade().getPedidosResgatados().getPrimeiro();
        while (atual != null) {
            Pedido pedido = atual.getValor();
            System.out.printf("- %s (Qtd: %d) - Valor original: R$ %.2f%n",
                pedido.getDescricao(),
                pedido.getQuantidade(),
                pedido.getPreco());
            atual = atual.getProx();
        }
    }
}
