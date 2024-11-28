/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author Tiago Paiva
 */
import algoritmo.Dijkstra;
import algoritmo.Distancia;
import java.util.List;
import util.CarregarCSV;

public class CalcularRota {

    public static String calcularRota(String paisOrigem, String cidadeOrigemNome, String paisDestino, String cidadeDestinoNome, int autonomia) {
        // Carregar cidades próximas da origem e destino
        List<Cidade> cidades = CarregarCSV.carregarCidadesProximas(paisOrigem, cidadeOrigemNome, paisDestino, cidadeDestinoNome);
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

        // Cria o grafo e adiciona as arestas
        Grafo grafo = new Grafo(cidades.size());
        for (int i = 0; i < cidades.size(); i++) {
            for (int j = i + 1; j < cidades.size(); j++) {
                double distancia = Distancia.calcularDistancia(
                        cidades.get(i).getLatitude(),
                        cidades.get(i).getLongitude(),
                        cidades.get(j).getLatitude(),
                        cidades.get(j).getLongitude()
                );

                // Adiciona aresta apenas se a distância for menor ou igual à autonomia
                if (distancia <= autonomia) {
                    grafo.adicionarAresta(i, j, distancia);
                    grafo.adicionarAresta(j, i, distancia); // Aresta bidirecional
                    System.out.println("Aresta adicionada: " + cidades.get(i).getNome() + " -> " + cidades.get(j).getNome() + " | Distância: " + distancia + " km");
                } else {
                    System.out.println("Distância maior que a autonomia, não adicionada: " + cidades.get(i).getNome() + " -> " + cidades.get(j).getNome() + " | Distância: " + distancia + " km");
                }
            }
        }

        // Verificar se as cidades de origem e destino estão no grafo
        int indexOrigem = cidades.indexOf(cidadeOrigem);
        int indexDestino = cidades.indexOf(cidadeDestino);

        if (indexOrigem == -1 || indexDestino == -1) {
            return "Cidade de origem ou destino não encontrada no gráfico.";
        }

        // Calcula o caminho mais curto usando o algoritmo de Dijkstra
        Dijkstra dijkstra = new Dijkstra(cidades.size());
        dijkstra.setGraph(grafo.getGraph());
        List<Integer> caminho = dijkstra.dijkstra(indexOrigem, indexDestino);

        // Gera o resultado
        if (caminho != null && !caminho.isEmpty()) {
            StringBuilder resultado = new StringBuilder("Caminho mais curto: ");
            for (int i = 0; i < caminho.size(); i++) {
                resultado.append(cidades.get(caminho.get(i)).getNome());
                if (i < caminho.size() - 1) {
                    resultado.append(" -> ");
                }
            }
            double distanciaTotal = dijkstra.getDistanciaTotal(indexDestino);
            resultado.append("\nDistância total: ").append(distanciaTotal).append(" km");
            return resultado.toString();
        } else {
            return "Não foi possível encontrar um caminho entre as cidades.";
        }
    }

}
