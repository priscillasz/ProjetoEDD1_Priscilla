package ed1priscilla.grafo;

import java.util.List;

public class Grafo {
    private final List<Ponto> pontos;
    private final List<Rua> ruas;

    public Grafo(List<Ponto> pontos, List<Rua> ruas) {
        this.pontos = pontos;
        this.ruas = ruas;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public List<Rua> getRuas() {
        return ruas;
    }
}
