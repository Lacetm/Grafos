package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertice {
    private String rotulo;
    private int grau;
    private boolean visitado;
    private Integer distancia = Integer.MAX_VALUE;
    private List<Vertice> menorCaminho = new LinkedList<>();
    private Map<Vertice, Integer> nodeAdjacente = new HashMap<>();

    public Map<Vertice, Integer> getNodeAdjacente() {
        return nodeAdjacente;
    }

    public void setNodeAdjacente(Map<Vertice, Integer> nodeAdjacente) {
        this.nodeAdjacente = nodeAdjacente;
    }

    public List<Vertice> getMenorCaminho() {
        return menorCaminho;
    }

    public void setMenorCaminho(List<Vertice> menorCaminho) {
        this.menorCaminho = menorCaminho;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public void addAdjacencia(Vertice vertice, int peso){
        nodeAdjacente.put(vertice, peso);

    }

    public int compareTo(Vertice vertice){
        return Integer.compare(this.distancia, vertice.getDistancia());
    }
    public void setVisitado(boolean valor){
        this.visitado = valor;
    }
    public boolean isVisited(){
        if (this.visitado==true){
            return true;
        }
        else {
            return false;
        }

    }

    public Vertice(String rotulo){
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }

    public int getGrau() {
        return grau;
    }

    public void addGrau(int value){
        this.grau += value;
    }

    @Override
    public String toString(){
        return rotulo + ":" + grau;
    }
}
