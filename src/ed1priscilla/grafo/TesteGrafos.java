package ed1priscilla.grafo;

import java.util.*;

public class TesteGrafos {
    public static void main(String[] args) {
        List<Ponto> nodes = new ArrayList<>();
        List<Rua> edges = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            Ponto location = new Ponto("Ponto_" + i, "Ponto_" + i);
            nodes.add(location);
        }

        addLane("Rua_0", 0, 1, 85, nodes, edges);
        addLane("Rua_1", 0, 2, 217, nodes, edges);
        addLane("Rua_2", 0, 4, 173, nodes, edges);
        addLane("Rua_3", 2, 6, 186, nodes, edges);
        addLane("Rua_4", 2, 7, 103, nodes, edges);
        addLane("Rua_5", 3, 7, 183, nodes, edges);
        addLane("Rua_6", 5, 8, 250, nodes, edges);
        addLane("Rua_7", 8, 9, 84, nodes, edges);
        addLane("Rua_8", 7, 9, 167, nodes, edges);
        addLane("Rua_9", 4, 9, 502, nodes, edges);
        addLane("Rua_10", 9, 10, 40, nodes, edges);
        addLane("Rua_11", 1, 10, 600, nodes, edges);

        /* Testa o menor caminho para chegar do Ponto 0 ao Ponto 10 */
        Grafo grafo = new Grafo(nodes, edges);
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo);
        dijkstra.executar(nodes.get(0));
        LinkedList<Ponto> caminho = dijkstra.getCaminho(nodes.get(10));

        System.out.println("\nMenor caminho para chegar ao Ponto 10 partindo do Ponto 0: ");
        for (Ponto ponto : caminho) {
            System.out.println(ponto);
        }
    }

    public static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration, List<Ponto> nodes, List<Rua> edges) {
        Rua lane = new Rua(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
