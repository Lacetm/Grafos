package graphs;

import java.util.*;

public class Aresta implements Comparable<Aresta> {
    private String rotulo;
    private Integer distancia = Integer.MAX_VALUE;
    private List<Aresta> menorCaminho = new LinkedList<>();
    private Map<Aresta, Integer> nodeAdjacente = new HashMap<Aresta, Integer>();

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public Aresta(String a) {
        this.rotulo = a;
    }

    public Map<Aresta, Integer> getNodeAdjacente() {
        return nodeAdjacente;
    }

    public void setNodeAdjacente(Map<Aresta, Integer> nodeAdjacente) {
        this.nodeAdjacente = nodeAdjacente;
    }

    public List<Aresta> getMenorCaminho() {
        return menorCaminho;
    }

    public void setMenorCaminho(List<Aresta> menorCaminho) {
        this.menorCaminho = menorCaminho;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public void addAdjacencia(Aresta aresta, int peso){
        nodeAdjacente.put(aresta, peso);

    }

    @Override
    public int compareTo(Aresta vertice){
        return Integer.compare(this.distancia, vertice.getDistancia());
    }


    }

