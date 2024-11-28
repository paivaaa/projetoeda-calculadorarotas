package modelo;

import java.io.*;

public class Grafo {
    private double[][] graph;

    public Grafo(int n) {
        graph = new double[n][n];
        // Inicializa a matriz com infinito (não há caminho entre as cidades)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i][j] = Double.POSITIVE_INFINITY;
                } else {
                    graph[i][j] = 0;
                }
            }
        }
    }

    public void adicionarAresta(int i, int j, double distancia) {
        // Apenas adiciona a aresta se a distância for positiva
        if (distancia > 0) {
            graph[i][j] = distancia;
            graph[j][i] = distancia; // Grafo não direcionado
        }
    }

    public double[][] getGraph() {
        return graph;
    }
}

