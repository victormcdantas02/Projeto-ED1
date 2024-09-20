public class NoDuplo {
    //Inserir tipo de valor de nó dependendo de como for usar o tipo de lista (para classe Evento, Hospital ou Restaurante, conforme indica o projeto)
    public NoDuplo prox;
    public NoDuplo anter;

    public NoDuplo(NoDuplo prox, NoDuplo anter){
        this.prox = prox;
        this.anter = anter;
    }
}
