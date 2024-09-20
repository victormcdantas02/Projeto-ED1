public class NoCircular {
    //Inserir tipo de valor de nó dependendo de como for usar o tipo de lista (para classe Evento, Hospital ou Restaurante, conforme indica o projeto)
    NoCircular prox;
    NoCircular anter;

    public NoCircular(NoCircular prox, NoCircular anter){
        this.prox = prox;
        this.anter = anter;
    }

}
