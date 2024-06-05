package util;

import graphs.Grafo;
import graphs.Vertice;

import java.util.*;

public class DFS {
    private Stack<Vertice> pilhaVertices;
    private List<String> visitados;
    private Grafo grafo;

    public Stack<Vertice> getPilhaVertices() {
        return pilhaVertices;
    }

    public void setPilhaVertices(Stack<Vertice> pilhaVertices) {
        this.pilhaVertices = pilhaVertices;
    }

    public List<String> getVisitados() {
        return visitados;
    }

    public void setVisitados(List<String> visitados) {
        this.visitados = visitados;
    }

    public DFS(Grafo grafo) {
        this.pilhaVertices = new Stack<>();
        this.visitados = new ArrayList<>();
        this.grafo = grafo;
    }

    public List<Vertice> caminho(String rotuloOrigem) throws Exception {
        List<Vertice> acessados = new ArrayList<>();

        Vertice origem = grafo.getVertice(rotuloOrigem);

        visitados.add(origem.getRotulo());
        pilhaVertices.push(origem);

        while (!pilhaVertices.isEmpty()) {
            Vertice atual = pilhaVertices.pop();
            acessados.add(atual);


            for (Vertice vizinho : grafo.getAdjacentes(atual.getRotulo())) {
                if (!visitados.contains(vizinho.getRotulo())) {
                    visitados.add(vizinho.getRotulo());
                    pilhaVertices.push(vizinho);
                }
            }
        }
        return acessados;
    }

    public List<Vertice> buscarEmProfundidade(Grafo grafo, String rotuloOrigem, String rotuloDestino) {
        if (!grafo.isVerticeExiste(rotuloOrigem) || !grafo.isVerticeExiste(rotuloDestino)) {
            throw new IllegalArgumentException("Informe um rótulo válido!");
        }
        grafo.criarMatrizAdjacencia();

        Stack<Vertice> pilha = new Stack<>();
        Map<Vertice, Vertice> caminho = new HashMap<>();
        Set<Vertice> visitados = new HashSet<>();

        Vertice origem = grafo.getVertice(rotuloOrigem);
        Vertice destino = grafo.getVertice(rotuloDestino);

        pilha.push(origem);
        visitados.add(origem);
        caminho.put(origem, null);

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.pop();

            if (atual.equals(destino)) {
                List<Vertice> caminhoEncontrado = construirCaminho(caminho, destino);
                System.out.println("Caminho DFS encontrado: " + caminhoEncontrado);
                return caminhoEncontrado;
            }

            for (Vertice adjacente : grafo.matrizAdjacencia.getAdjacentes(grafo.rotuloEmIndice.get(atual.getRotulo()))) {
                if (!visitados.contains(adjacente)) {
                    pilha.push(adjacente);
                    visitados.add(adjacente);
                    caminho.put(adjacente, atual);
                }
            }
        }

        System.out.println("Nenhum caminho encontrado com DFS.");
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
