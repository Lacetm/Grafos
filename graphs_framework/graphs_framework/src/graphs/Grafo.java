package graphs;

import exception.QtdeMaximaException;

import java.util.*;

public class Grafo {
    private int qtdeMaximaVertices;
    private int qtdeAtualVertices;
    private List<Vertice> vertices;
    private MatrizAdjacencia matrizAdjacencia;
    private Map<String, Integer> rotuloEmIndice;

    public Grafo(int qtde) throws IllegalArgumentException{
        if(qtde <= 0){
            throw new IllegalArgumentException("Informe uma quantidade vertices válida.");
        }
        this.qtdeMaximaVertices = qtde;
        this.vertices = new ArrayList<>();
        this.rotuloEmIndice = new HashMap<>();
    }

    public void addVertice(String rotulo) throws QtdeMaximaException{
        if(qtdeAtualVertices > qtdeMaximaVertices-1){
            throw new QtdeMaximaException("Não é possível adicionar mais Vertices.");
        }
        Vertice vertice = new Vertice(rotulo);
        this.vertices.add(vertice);
        this.rotuloEmIndice.put(rotulo, qtdeAtualVertices);
        qtdeAtualVertices++;
    }

    public void conectarVertices(String rotuloVerticeOrigem, String rotuloVerticeDestino) throws IllegalArgumentException{
        if(!isVerticeExiste(rotuloVerticeOrigem) || !isVerticeExiste(rotuloVerticeDestino)) {
            throw new IllegalArgumentException("Informe um rótulo válido!");
        }
        int indiceVerticeOrigem = rotuloEmIndice.get(rotuloVerticeOrigem);
        int indiceVerticeDestino = rotuloEmIndice.get(rotuloVerticeDestino);
        criarMatrizAdjacencia();
        this.matrizAdjacencia.conectarVertices(indiceVerticeOrigem, indiceVerticeDestino);


    }


    public Vertice getVertice(String rotulo) {
        if(!isVerticeExiste(rotulo)) {
            throw new IllegalArgumentException("Informe um rótulo válido!");
        }else {
            int indexVertice = rotuloEmIndice.get(rotulo);
            return this.vertices.get(indexVertice);
        }
    }

    public List<Vertice> getAdjacentes(String rotulo) throws Exception{
        if(!isVerticeExiste(rotulo)) {
            throw new IllegalArgumentException("Informe um rótulo válido");
        }
        if(matrizAdjacencia == null) {
            throw new Exception("Crie a matriz de adjacencia antes!");
        }
        int indiceRotulo = rotuloEmIndice.get(rotulo);
        return matrizAdjacencia.getAdjacentes(indiceRotulo);

    }

    private void criarMatrizAdjacencia() {
        if(this.matrizAdjacencia == null) {
            this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<>(vertices));
        }
    }

    void BFS (int s, boolean[] visitado) {


    }

    private boolean isVerticeExiste(String rotulo) {
        return rotuloEmIndice.get(rotulo) != null ? true : false;
    }
}
