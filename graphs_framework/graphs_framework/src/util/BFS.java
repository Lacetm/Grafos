package util;

import graphs.Grafo;
import graphs.Vertice;

import java.util.*;

public class BFS {
    private final Grafo grafo;
    private final Vertice verticeInicial;

    public BFS(String rotulo, Grafo grafo) {
        this.grafo = grafo;
        this.verticeInicial = grafo.getVertice(rotulo);

    }

    public void traverse() throws Exception {
        Queue<Vertice> fila = new LinkedList<>();
        fila.add(verticeInicial);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();

            if (!atual.isVisited()) {
                atual.setVisitado(true);
                System.out.println("Grafo Visitado: " + atual);

                // Obtem os adjacentes do vértice atual
                List<Vertice> adjacentes;
                try {
                    adjacentes = grafo.getAdjacentes(atual.getRotulo());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                // Adiciona os adjacentes do vértice atual à fila
                for (Vertice adjacente : adjacentes) {
                    if (!adjacente.isVisited()) {
                        fila.add(adjacente);
                    }


                }

            }

        }

    }

    public void directedTraverse(String origem, String destino) throws Exception {
        Queue<String> fila = new LinkedList<>();
        Queue<Vertice> anterior = new LinkedList<>();
        Queue<Vertice> visitados = new LinkedList<>();


        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice atual = grafo.getVertice(fila.poll());


            if (atual.getRotulo().equals(destino)){

            }

            if (!atual.isVisited()) {
                visitados.add(atual);
                atual.setVisitado(true);

                System.out.println("Grafo Visitado: " + atual);

                // Obtem os adjacentes do vértice atual
                List<Vertice> adjacentes;
                try {
                    adjacentes = grafo.getAdjacentes(atual.getRotulo());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                // Adiciona os adjacentes do vértice atual à fila
                for (Vertice adjacente : adjacentes) {
                    if (!adjacente.isVisited()) {
                        fila.add(String.valueOf(adjacente));
                    }

                }

            }
        }
    }
}
