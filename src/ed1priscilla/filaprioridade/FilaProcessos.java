package ed1priscilla.filaprioridade;

public class FilaProcessos {
    Processo[] pr = new Processo[100000];
    int size = 0; // tamanho da Array de processos

    /* Inserir/enfileirar um novo processo na fila */
    public void enfileirar(int pid, int bt, int priority) {

        pr[size] = new Processo();
        pr[size].bt = bt;
        pr[size].priority = priority;
        pr[size].pid = pid;

        size++;
    }

    /* Descobrir o tempo de espera de cada processo
    *  Tempo de espera = bt do processo anterior + wt do processo anterior
    *  Obs: tempo de espera do primeiro processo é sempre 0. */
    public void descobrirTempoMedioEspera() {
        pr[0].wt = 0;

        for (int i = 1; i < size; i++) {
            pr[i].wt = pr[i-1].bt + pr[i-1].wt;
        }
    }

    /* Descobrir o turn around time de cada processo
    * Turn around time = bt + wt */
    public void descobrirTATmedio() {
        for (int i = 0; i < size; i++) {
            pr[i].tat = pr[i].bt + pr[i].wt;
        }
    }

    /* Descobrir tempo médio de espera e average turn around time */
    public void descobrirTempoMedio() {
        int total_wt = 0, total_tat = 0;

        // cálculo do tempo e do tat médio
        descobrirTempoMedioEspera();
        descobrirTATmedio();

        // impressão e cálculo dos dados do processo
        System.out.print("\nProcesso   Tempo de estouro   Tempo de espera   Turn around time    Prioridade\n");

        for (int i = 0; i < size; i++) {
            total_wt += pr[i].wt;
            total_tat += pr[i].tat;
            System.out.print(" " + pr[i].getPid() + "\t\t\t" + pr[i].getBt() + "\t\t\t\t\t" + pr[i].getWt() + "\t\t\t\t" + pr[i].getTat() + "\t\t\t\t\t" + pr[i].getPriority() +  "\n");
        }

        // Impressão e cálculo da média do tempo e do turn around time
        System.out.print("\nTempo médio de espera = " +(float)total_wt / (float)size);
        System.out.print("\nAverage turn around time = "+(float)total_tat / (float)size);

    }

    /* Ordenar processos por prioridade */
    public void ordenar() {
        int temp;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // ordenar por prioridade quando os arrival time são iguais
                if (pr[j].priority < pr[j+1].priority) {

                    // trocar id dos processos
                    temp = pr[j].pid;
                    pr[j].pid = pr[j+1].pid;
                    pr[j+1].pid = temp;

                    // trocar tempo de estouro
                    temp = pr[j].bt;
                    pr[j].bt = pr[j+1].bt;
                    pr[j+1].bt = temp;

                    // trocar prioridade
                    temp = pr[j].priority;
                    pr[j].priority = pr[j+1].priority;
                    pr[j+1].priority = temp;
                }
            }
        }
    }

    public void escalonamentoFIFO() {
        ordenar();

        System.out.print("Ordem em que os processos são executados: \n");
        for (int i = 0 ; i < size; i++)
            System.out.print(pr[i].pid + " ") ;

        descobrirTempoMedio();
    }
}
