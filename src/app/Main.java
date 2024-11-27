package app;

import algoritmo.Dijkstra;
import algoritmo.Distancia;
import java.util.List;
import java.util.Scanner;
import modelo.Cidade;
import modelo.Grafo;
import util.CarregarCSV;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = null;

        System.out.println("Bem-vindo a Calculadora de Roras");

        do {
            // Solicita o nome do país ao usuário
            System.out.print("Digite o nome do pais: ");
            String paisEscolhido = scanner.nextLine().trim();

            // Carregar cidades do país escolhido
            List<Cidade> cidades = CarregarCSV.carregarCidades(paisEscolhido);

            if (cidades.isEmpty()) {
                System.out.println("Nenhuma cidade encontrada para o pais: " + paisEscolhido);
                return;
            }

            System.out.println("\nCidades disponiveis:");
            String cidadesFormatadas = String.join(", ", cidades.stream().map(Cidade::getNome).toList());
            System.out.println(cidadesFormatadas);

            // Solicita a cidade de origem e destino
            System.out.print("\nDigite o nome da cidade de origem: ");
            String cidadeOrigem = scanner.nextLine().trim();
            System.out.print("Digite o nome da cidade de destino: ");
            String cidadeDestino = scanner.nextLine().trim();

            // Verifica se as cidades estão na lista
            Cidade origem = null, destino = null;
            for (Cidade cidade : cidades) {
                if (cidade.getNome().equalsIgnoreCase(cidadeOrigem)) {
                    origem = cidade;
                }
                if (cidade.getNome().equalsIgnoreCase(cidadeDestino)) {
                    destino = cidade;
                }
            }

            if (origem == null || destino == null) {
                System.out.println("Uma ou ambas as cidades nao foram encontradas.");
                continue; // Reinicia o loop para perguntar novamente
            }

            // Define autonomia do automóvel
            int autonomia = 200; // Em km

            // Cria o grafo com base na distância em linha reta
            Grafo grafo = new Grafo(cidades.size());
            for (int i = 0; i < cidades.size(); i++) {
                for (int j = i + 1; j < cidades.size(); j++) {
                    double distancia = Distancia.calcularDistancia(
                            cidades.get(i).getLatitude(),
                            cidades.get(i).getLongitude(),
                            cidades.get(j).getLatitude(),
                            cidades.get(j).getLongitude()
                    );
                    if (distancia <= autonomia) {
                        grafo.adicionarAresta(i, j, distancia);
                    }
                }
            }

            // Executa o algoritmo de Dijkstra
            System.out.println("\nCalculando o caminho mais curto entre " + cidadeOrigem + " e " + cidadeDestino + "...");
            int indexOrigem = cidades.indexOf(origem);
            int indexDestino = cidades.indexOf(destino);

            Dijkstra dijkstra = new Dijkstra(cidades.size());
            dijkstra.setGraph(grafo.getGraph());

            // Calculando o caminho mais curto
            List<Integer> caminho = dijkstra.dijkstra(indexOrigem, indexDestino);

            if (caminho != null && !caminho.isEmpty()) {
                System.out.println("Caminho mais curto: ");
                for (int i = 0; i < caminho.size(); i++) {
                    System.out.print(cidades.get(caminho.get(i)).getNome());
                    if (i < caminho.size() - 1) {
                        System.out.print(" -> ");
                    }
                }

                // Distância total
                double distanciaTotal = dijkstra.getDistanciaTotal(indexDestino);
                System.out.println("\nDistancia total: " + distanciaTotal + " km");
            } else {
                System.out.println("Nao foi possível encontrar um caminho entre as cidades.");
            }

            // Pergunta ao utilizador se deseja calcular outra rota
            System.out.print("\nDeseja calcular uma nova rota? (sim/nao): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("sim"));

        System.out.println("Obrigado por usar o programa!");
        scanner.close();
    }
}
