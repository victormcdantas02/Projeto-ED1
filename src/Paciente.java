import java.util.Date;

public class Paciente {
    private String nome;
    private int idade;
    private String historicoMedico;
    private Date ultimaConsulta;
    private ListaCircular<Consulta> registroConsultas;
    
    public Paciente(String nome, int idade, String historicoMedico, Date ultimaConsulta) {
        this.nome = nome;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
        this.ultimaConsulta = ultimaConsulta;
        registroConsultas = new ListaCircular<>();
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

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public Date getUltimaConsulta() {
        return ultimaConsulta;
    }

    public void setUltimaConsulta(Date ultimaConsulta) {
        this.ultimaConsulta = ultimaConsulta;
    }
    
    public ListaCircular<Consulta> getRegistroConsultas(){
        return registroConsultas;
    }
    
}
