package ed1priscilla.filaprioridade;

public class TesteProcessos {
    public static void main(String[] args) {
        // int n = 3;
        FilaProcessos ob = new FilaProcessos();

        ob.enfileirar(1, 10, 2);
        ob.enfileirar(2, 5, 0);
        ob.enfileirar(3, 8, 1);

        ob.escalonamentoFIFO();
    }
}
