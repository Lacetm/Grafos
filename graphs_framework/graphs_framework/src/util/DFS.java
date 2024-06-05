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
                if(!visitados.contains(vizinho.getRotulo())) {
                    visitados.add(vizinho.getRotulo());
                    pilhaVertices.push(vizinho);
                }
            }
        }
        return acessados;
    }
}
