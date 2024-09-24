import java.util.Date;
public class Evento {
    String nome;
        String local;
        int capacidade;
        Date diaDoEvento;
    public Evento(String nome, String local, int capacidade, Date diaDoEvento) {
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
        this.diaDoEvento = diaDoEvento;
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
    
}
