/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tiago Paiva e Mário Bonacho
 */
package modelo;

public class Grafo {
    private double[][] graph; 

    public Grafo(int numVertices) {
        this.graph = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph[i][j] = -1; // -1 representa ausência de aresta
            }
        }
    }

    public void adicionarAresta(int i, int j, double distancia) {
        this.graph[i][j] = distancia;
        this.graph[j][i] = distancia;  // Grafo não direcionado
    }

    public double[][] getGraph() {
        return graph;
    }
}

