package ed1priscilla.grafo;

import java.util.*;

public class AlgoritmoDijkstra {
    private final List<Ponto> nodes; // elos - pontos
    private final List<Rua> edges; // arestas - ruas
    private Set<Ponto> settledNodes; // elos resolvidos
    private Set<Ponto> unSettledNodes; // elos não resolvidos
    private Map<Ponto, Ponto> predecessors;
    private Map<Ponto, Integer> distance; // distancia

    /* Construtor */
    public AlgoritmoDijkstra(Grafo grafo) {
        // criação de uma cópia da Array para que possa ser utilizada
        this.nodes = new ArrayList<Ponto>(grafo.getPontos());
        this.edges = new ArrayList<Rua>(grafo.getRuas());
    }

    /* Enquanto o set unsettledNodes não estiver vazio, vai descobrindo o ponto mínimo e adicionando o elo no set
    * dos settledNodes e o removendo dos unsettledNodes. Em seguida, descobre a distancia minima.*/
    public void executar(Ponto origem) {
        settledNodes = new HashSet<Ponto>();
        unSettledNodes = new HashSet<Ponto>();
        distance = new HashMap<Ponto, Integer>();
        predecessors = new HashMap<Ponto, Ponto>();

        distance.put(origem, 0);
        unSettledNodes.add(origem);

        while (unSettledNodes.size() > 0) {
            Ponto node = getMinimo(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            descobrirDistanciasMinimas(node);
        }
    }

    /* Descobrir a distancia minima */
    private void descobrirDistanciasMinimas(Ponto node) {
        List<Ponto> adjacentNodes = getNeighbors(node);
        for (Ponto target : adjacentNodes) {
            if (getMenorDistancia(target) > getMenorDistancia(node)
                    + getDistancia(node, target)) {
                distance.put(target, getMenorDistancia(node)
                        + getDistancia(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    /**/
    private int getDistancia(Ponto node, Ponto target) {
        for (Rua edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }


    private List<Ponto> getNeighbors(Ponto node) {
        List<Ponto> neighbors = new ArrayList<>();
        for (Rua edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Ponto getMinimo(Set<Ponto> pontos) {
        Ponto minimum = null;
        for (Ponto ponto : pontos) {
            if (minimum == null) {
                minimum = ponto;
            } else {
                if (getMenorDistancia(ponto) < getMenorDistancia(minimum)) {
                    minimum = ponto;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Ponto ponto) {
        return settledNodes.contains(ponto);
    }

    private int getMenorDistancia(Ponto destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Ponto> getCaminho(Ponto target) {
        LinkedList<Ponto> caminho = new LinkedList<>();
        Ponto step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        caminho.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            caminho.add(step);
        }
        // Put it into the correct order
        Collections.reverse(caminho);
        return caminho;
    }
}
