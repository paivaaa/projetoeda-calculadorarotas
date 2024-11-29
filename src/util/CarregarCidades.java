package util;

import algoritmo.Distancia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidade;

public class CarregarCidades {

    // Método para carregar todas as cidades do arquivo CSV
    public static List<Cidade> carregarTodasCidades() {
        String filePath = "src/resources/worldcities.csv"; // Caminho para o ficheiro CSV
        List<Cidade> cidades = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Pula a linha de cabeçalhos
                }

                String[] parts = line.split(",");
                if (parts.length > 5) { // Verifica se a linha contém informações suficientes
                    String nome = parts[1].replace("\"", "");
                    double latitude = Double.parseDouble(parts[2].replace("\"", ""));
                    double longitude = Double.parseDouble(parts[3].replace("\"", ""));
                    cidades.add(new Cidade(nome, latitude, longitude));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter coordenadas: " + e.getMessage());
        }
        return cidades;
    }

    // Método para carregar cidades próximas da origem ou destino
    public static List<Cidade> carregarCidadesProximas(String cidadeOrigemNome, String cidadeDestinoNome) {
        String filePath = "src/resources/worldcities.csv"; // Caminho para o ficheiro CSV
        List<Cidade> todasCidades = carregarTodasCidades();
        List<Cidade> cidadesFiltradas = new ArrayList<>();

        Cidade origem = todasCidades.stream()
            .filter(c -> c.getNome().equalsIgnoreCase(cidadeOrigemNome))
            .findFirst()
            .orElse(null);

        Cidade destino = todasCidades.stream()
            .filter(c -> c.getNome().equalsIgnoreCase(cidadeDestinoNome))
            .findFirst()
            .orElse(null);

        if (origem == null || destino == null) {
            return cidadesFiltradas; // Retorna lista vazia se origem ou destino não forem encontrados
        }

      
        double raio = 1000;

        for (Cidade cidade : todasCidades) {
            double distanciaParaOrigem = Distancia.calcularDistancia(
                cidade.getLatitude(), cidade.getLongitude(),
                origem.getLatitude(), origem.getLongitude());
            double distanciaParaDestino = Distancia.calcularDistancia(
                cidade.getLatitude(), cidade.getLongitude(),
                destino.getLatitude(), destino.getLongitude());

            if (distanciaParaOrigem <= raio || distanciaParaDestino <= raio) {
                cidadesFiltradas.add(cidade);
            }
        }

        return cidadesFiltradas;
    }
}