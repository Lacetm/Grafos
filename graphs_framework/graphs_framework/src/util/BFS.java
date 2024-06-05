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

    public List<Vertice> buscarEmLargura(Grafo grafo, String rotuloOrigem, String rotuloDestino) {
        if (!grafo.isVerticeExiste(rotuloOrigem) || !grafo.isVerticeExiste(rotuloDestino)) {
            throw new IllegalArgumentException("Informe um rótulo válido!");
        }
        grafo.criarMatrizAdjacencia();

        Queue<Vertice> fila = new LinkedList<>();
        Map<Vertice, Vertice> caminho = new HashMap<>();
        Set<Vertice> visitados = new HashSet<>();

        Vertice origem = grafo.getVertice(rotuloOrigem);
        Vertice destino = grafo.getVertice(rotuloDestino);

        fila.add(origem);
        visitados.add(origem);
        caminho.put(origem, null);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();

            if (atual.equals(destino)) {
                List<Vertice> caminhoEncontrado = construirCaminho(caminho, destino);
                System.out.println("Caminho BFS encontrado: " + caminhoEncontrado);
                return caminhoEncontrado;
            }

            for (Vertice adjacente : grafo.matrizAdjacencia.getAdjacentes(grafo.rotuloEmIndice.get(atual.getRotulo()))) {
                if (!visitados.contains(adjacente)) {
                    fila.add(adjacente);
                    visitados.add(adjacente);
                    caminho.put(adjacente, atual);
                }
            }
        }

        System.out.println("Nenhum caminho encontrado com BFS.");
        return null; // Se não houver caminho
    }
    private List<Vertice> construirCaminho(Map<Vertice, Vertice> caminho, Vertice destino) {
        List<Vertice> caminhoEncontrado = new LinkedList<>();
        for (Vertice v = destino; v != null; v = caminho.get(v)) {
            caminhoEncontrado.add(0, v);
        }
        return caminhoEncontrado;
    }
}
