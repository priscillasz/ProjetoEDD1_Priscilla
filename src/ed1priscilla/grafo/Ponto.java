package ed1priscilla.grafo;

import ed1priscilla.graph3.Vertex;

public class Ponto {
    final private String id; // id do Ponto
    final private String name; // nome do Ponto

    /* construtor */
    public Ponto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /* getters */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /* hashcode */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /* equals */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ponto other = (Ponto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /* toString */
    @Override
    public String toString() {
        return name;
    }
}
