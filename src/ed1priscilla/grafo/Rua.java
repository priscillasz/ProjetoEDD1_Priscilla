package ed1priscilla.grafo;

public class Rua { // aresta - edge
    private final String id; // id da rua
    private final Ponto source; // origem
    private final Ponto destination; // destino
    private final int weight; // peso

    /* construtores */
    public Rua(String id, Ponto source, Ponto destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /* getters */
    public String getId() {
        return id;
    }
    public Ponto getDestination() {
        return destination;
    }

    public Ponto getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    /* toString */
    @Override
    public String toString() {
        return source + " " + destination;
    }
}
