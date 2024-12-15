/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tiago Paiva e Mário Bonacho
 */
package algoritmo;

import java.util.*;

public class Dijkstra {

    private double[] dist;  
    private int[] prev;
    private double[][] graph;

    public Dijkstra(int n) {
        dist = new double[n];
        prev = new int[n];
    }

    public void setGraph(double[][] graph) {
        this.graph = graph;
    }

    public List<Integer> dijkstra(int origem, int destino) {
        int n = dist.length;
        Arrays.fill(dist, Double.MAX_VALUE);  
        Arrays.fill(prev, -1);

        dist[origem] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> dist[i]));
        pq.add(origem);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (u == destino) {
                break;
            }

            for (int v = 0; v < graph[u].length; v++) {
                if (graph[u][v] != -1) {
                    double alt = dist[u] + graph[u][v];
                    if (alt < dist[v]) {
                        dist[v] = alt;
                        prev[v] = u;
                        pq.add(v);
                    }
                }
            }
        }

        List<Integer> caminho = new ArrayList<>();
        for (int v = destino; v != -1; v = prev[v]) {
            caminho.add(v);
        }
        Collections.reverse(caminho);

        return caminho.size() == 1 && caminho.get(0) != origem ? null : caminho;
    }

    public double getDistanciaTotal(int destino) {
        return dist[destino];
    }
}
