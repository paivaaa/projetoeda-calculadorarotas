package util;

import modelo.Cidade;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarregarCSV {

    private static final String FILE_PATH = "src/resources/worldcities.csv";

    // Carregar cidades de um país
    public static List<Cidade> carregarCidades(String paisEscolhido) {
        List<Cidade> cidades = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = br.readLine(); // Ignora cabeçalho
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 5 && parts[4].replace("\"", "").equalsIgnoreCase(paisEscolhido)) {
                    String nome = parts[1].replace("\"", "");
                    double latitude = Double.parseDouble(parts[2].replace("\"", ""));
                    double longitude = Double.parseDouble(parts[3].replace("\"", ""));
                    cidades.add(new Cidade(nome, latitude, longitude));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
        }

        return cidades;
    }

    // Carregar cidades próximas de origem e destino
    public static List<Cidade> carregarCidadesProximas(String paisOrigem, String cidadeOrigemNome, String paisDestino, String cidadeDestinoNome) {
        // Carregar as cidades para os países de origem e destino
        List<Cidade> cidadesOrigem = carregarCidades(paisOrigem);
        List<Cidade> cidadesDestino = carregarCidades(paisDestino);

        // Encontrar as cidades de origem e destino
        Cidade origem = cidadesOrigem.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(cidadeOrigemNome))
                .findFirst()
                .orElse(null);

        Cidade destino = cidadesDestino.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(cidadeDestinoNome))
                .findFirst()
                .orElse(null);

        // Verificar se as cidades foram encontradas
        if (origem == null || destino == null) {
            System.err.println("Origem ou destino não encontrado!");
            return new ArrayList<>();
        }

        // Adicionar as cidades de origem e destino ao resultado
        List<Cidade> cidadesFiltradas = new ArrayList<>();
        cidadesFiltradas.add(origem);
        cidadesFiltradas.add(destino);

        return cidadesFiltradas;
    }

}
