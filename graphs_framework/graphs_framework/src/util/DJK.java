package util;

import graphs.Aresta;
import graphs.Grafo;
import graphs.Vertice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DJK {
    private Vertice verticeInicial;
    private Grafo grafo;

    public DJK() {

    }


    public void calculateShortestPath(Aresta fonte) throws Exception {
        fonte.setDistancia(0);
        Set<Aresta> settledNodes = new HashSet<>();
        Queue<Aresta> unsettledNodes = new PriorityQueue<>(Collections.singleton(fonte));

        while (!unsettledNodes.isEmpty()) {
            Aresta atual = unsettledNodes.poll();
            atual.getNodeAdjacente()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), atual);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(atual);
        }
    }



    private void evaluateDistanceAndPath(Aresta adj, Integer peso, Aresta fonte) {
        Integer newDistance = fonte.getDistancia() + peso;
        if (newDistance < adj.getDistancia()) {
            adj.setDistancia(newDistance);
            adj.setMenorCaminho(Stream.concat(fonte.getMenorCaminho().stream(), Stream.of(fonte)).toList());
        }
    }

    public void printPaths(List<Aresta> arestas) {
        arestas.forEach(node -> {
            String path = node.getMenorCaminho().stream()
                    .map(Aresta::getRotulo).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getRotulo(), node.getDistancia())
                    : "%s -> %s : %s".formatted(path, node.getRotulo(), node.getDistancia()))
            );
        });
    }

}
