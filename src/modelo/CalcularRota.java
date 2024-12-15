/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tiago Paiva e Mário Bonacho
 */
package modelo;

import algoritmo.Dijkstra;
import algoritmo.Distancia;

import java.util.List;
import util.CarregarCidades;

public class CalcularRota {

    public static String calcularRota(String cidadeOrigemNome, String cidadeDestinoNome, int autonomia) {
        // Carregar cidades próximas da origem e destino
        List<Cidade> cidades = CarregarCidades.carregarCidadesProximas(cidadeOrigemNome, cidadeDestinoNome);
        if (cidades.isEmpty()) {
            return "Nenhuma cidade encontrada próxima à origem ou destino.";
        }

        // Localizar a cidade de origem
        Cidade cidadeOrigem = cidades.stream()
            .filter(c -> c.getNome().equalsIgnoreCase(cidadeOrigemNome))
            .findFirst()
            .orElse(null);
        if (cidadeOrigem == null) {
            return "Cidade de origem não encontrada.";
        }

        // Localizar a cidade de destino
        Cidade cidadeDestino = cidades.stream()
            .filter(c -> c.getNome().equalsIgnoreCase(cidadeDestinoNome))
            .findFirst()
            .orElse(null);
        if (cidadeDestino == null) {
            return "Cidade de destino não encontrada.";
        }

        // Cria o grafo
        Grafo grafo = new Grafo(cidades.size());
        for (int i = 0; i < cidades.size(); i++) {
            for (int j = i + 1; j < cidades.size(); j++) {
                double distancia = Distancia.calcularDistancia(
                    cidades.get(i).getLatitude(),
                    cidades.get(i).getLongitude(),
                    cidades.get(j).getLatitude(),
                    cidades.get(j).getLongitude()
                );
                // Arredondar a distância para 2 casas decimais
                distancia = Math.round(distancia * 100.0) / 100.0;

                if (distancia <= autonomia) {
                    grafo.adicionarAresta(i, j, distancia);
                }
            }
        }

        // Calcula o caminho mais curto usando Dijkstra
        int indexOrigem = cidades.indexOf(cidadeOrigem);
        int indexDestino = cidades.indexOf(cidadeDestino);

        Dijkstra dijkstra = new Dijkstra(cidades.size());
        dijkstra.setGraph(grafo.getGraph());
        List<Integer> caminho = dijkstra.dijkstra(indexOrigem, indexDestino);

        // Gera o resultado
        if (caminho != null) {
            StringBuilder resultado = new StringBuilder("Caminho mais curto: ");
            for (int i = 0; i < caminho.size(); i++) {
                resultado.append(cidades.get(caminho.get(i)).getNome());
                if (i < caminho.size() - 1) {
                    resultado.append(" -> ");
                }
            }
            // Arredondar a distância total para 2 casas decimais
            double distanciaTotal = Math.round(dijkstra.getDistanciaTotal(indexDestino) * 100.0) / 100.0;
            resultado.append("\nDistância total: ").append(distanciaTotal).append(" km");
            return resultado.toString();
        } else {
            return "Não foi possível encontrar um caminho entre as cidades.";
        }
    }
}
