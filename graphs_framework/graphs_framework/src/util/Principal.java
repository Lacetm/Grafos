package util;

import graphs.Aresta;
import graphs.Grafo;

import java.util.List;


public class Principal {
    public static void main(String[] args) throws Exception {

        Grafo grafo = new Grafo(12);

        try {
            grafo.addVertice("F");
            grafo.addVertice("A");
            grafo.addVertice("G");
            grafo.addVertice("E");
            grafo.addVertice("B");
            grafo.addVertice("I");
            grafo.addVertice("D");
            grafo.addVertice("C");
            grafo.addVertice("H");
            grafo.addVertice("K");
            grafo.addVertice("J");

            grafo.conectarVertices("F", "A");

            grafo.conectarVertices("A", "G");
            grafo.conectarVertices("A", "B");
            grafo.conectarVertices("A", "E");

            grafo.conectarVertices("E", "D");

            grafo.conectarVertices("D", "I");
            grafo.conectarVertices("D", "C");

            grafo.conectarVertices("C", "B");
            grafo.conectarVertices("C", "H");

            grafo.conectarVertices("H", "K");
            grafo.conectarVertices("K", "J");
            grafo.conectarVertices("J", "B");



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
//        Aresta arestaF = new Aresta("F");
//        Aresta arestaA = new Aresta("A");
//        Aresta arestaG = new Aresta("G");
//        Aresta arestaE = new Aresta("E");
//        Aresta arestaD = new Aresta("D");
//        Aresta arestaI = new Aresta("I");
//        Aresta arestaC = new Aresta("C");
//        Aresta arestaB = new Aresta("B");
//        Aresta arestaH = new Aresta("H");
//        Aresta arestaK = new Aresta("K");
//        Aresta arestaJ = new Aresta("J");
//
//        arestaF.addAdjacencia(arestaA, 3);
//
//        arestaA.addAdjacencia(arestaG, 4);
//        arestaA.addAdjacencia(arestaB, 5);
//        arestaA.addAdjacencia(arestaE, 6);
//
//        arestaE.addAdjacencia(arestaD, 2);
//
//        arestaB.addAdjacencia(arestaC, 9);
//        arestaB.addAdjacencia(arestaJ, 7);
//
//        arestaD.addAdjacencia(arestaI, 5);
//        arestaD.addAdjacencia(arestaC, 8);
//
//        arestaC.addAdjacencia(arestaH, 9);
//
//        arestaH.addAdjacencia(arestaK, 3);
//
//        arestaK.addAdjacencia(arestaJ, 4);
//
//
//        DJK djk = new DJK();
//
//        djk.calculateShortestPath(arestaF);
//        djk.printPaths(List.of(
//                arestaF,
//                arestaA,
//                arestaG,
//                arestaB,
//                arestaE,
//                arestaD,
//                arestaI,
//                arestaC,
//                arestaJ,
//                arestaK,
//                arestaH
//
//                ));

//        try {
//            System.out.println(grafo.getVertice("A"));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        BFS bfs = new BFS("A", grafo);

        try {
            bfs.traverse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        bfs.bfs(grafo, "F", "I");


//        DFS dfs = new DFS(grafo);
//
//        dfs.caminho("F");
//
//        System.out.println(dfs.getPilhaVertices());
//        System.out.println(dfs.getVisitados());


    }
    }

