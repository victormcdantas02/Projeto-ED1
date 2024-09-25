public class Mesa {
    private String numero;
    private boolean disponibilidade;

    public Mesa(String numero, boolean disponibilidade) {
        this.numero = numero;
        this.disponibilidade = disponibilidade;
    }
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
  
}
