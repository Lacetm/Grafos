package graphs;

import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {

    private int matriz[][];
    private int qteVertices;
    private List<Vertice> vertices;

    public MatrizAdjacencia(List<Vertice> vertices){
        this.vertices = vertices;
        this.qteVertices = vertices.size();
        this.matriz = new int[qteVertices][qteVertices];
    }

    public void conectarVertices(int indiceVerticeInicial, int indiceVerticeFinal) {
        Vertice verticeInicial = vertices.get(indiceVerticeInicial);
        Vertice verticeFinal = vertices.get(indiceVerticeFinal);
        if (indiceVerticeInicial == indiceVerticeFinal) {
            matriz[indiceVerticeInicial][indiceVerticeFinal] += 1;
            verticeInicial.addGrau(2);
        } else {
            matriz[indiceVerticeInicial][indiceVerticeFinal] += 1;
            verticeInicial.addGrau(1);
            matriz[indiceVerticeFinal][indiceVerticeInicial] += 1;
            verticeFinal.addGrau(1);
        }
    }

    public List<Vertice> getAdjacentes(int indiceVertice){
        int linha = indiceVertice;
        List<Vertice> vizinhos = new ArrayList<>();
        for(int j = 0; j < vertices.size(); j++){
            if(matriz[linha][j] >= 1){
                Vertice tempVertice = vertices.get(j);
                vizinhos.add(tempVertice);
            }
        }
        return vizinhos;
    }

    public void imprimir(){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
