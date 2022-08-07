package ed1priscilla.filaprioridade;

public class Processo {
    protected int pid; // iD do Processo
    protected int bt; // Tempo de estouro (Burst Time)
    protected int priority; // Prioridade

    protected int wt; // Tempo de espera (Waiting Time)
    protected int tat; // Turn around time

    /* construtores */
    public Processo() {
    }

    public Processo(int pid, int bt, int priority) {
        this.pid = pid;
        this.bt = bt;
        this.priority = priority;
    }

    /* getters e setters */
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getBt() {
        return bt;
    }

    public void setBt(int bt) {
        this.bt = bt;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWt() {
        return wt;
    }

    public void setWt(int wt) {
        this.wt = wt;
    }

    public int getTat() {
        return tat;
    }

    public void setTat(int tat) {
        this.tat = tat;
    }
}
