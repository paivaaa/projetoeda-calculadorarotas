package app;

import java.util.List;
import java.util.Scanner;
import modelo.CalcularRota;
import modelo.Cidade;
import util.CarregarCSV;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = null;

        System.out.println("Bem-vindo a Calculadora de Rotas");

        do {
            // Solicita o país de origem e cidade de origem ao usuário
            System.out.print("Digite o nome do pais de origem: ");
            String paisOrigem = scanner.nextLine().trim();
            System.out.print("Digite o nome da cidade de origem: ");
            String cidadeOrigemNome = scanner.nextLine().trim();

            // Carregar cidades do país de origem
            List<Cidade> cidadesOrigem = CarregarCSV.carregarCidades(paisOrigem);
            if (cidadesOrigem.isEmpty()) {
                System.out.println("Nenhuma cidade encontrada para o pais de origem: " + paisOrigem);
                continue;
            }

            // Solicita o país de destino e cidade de destino ao usuário
            System.out.print("Digite o nome do país de destino: ");
            String paisDestino = scanner.nextLine().trim();
            System.out.print("Digite o nome da cidade de destino: ");
            String cidadeDestinoNome = scanner.nextLine().trim();

            // Carregar cidades do país de destino
            List<Cidade> cidadesDestino = CarregarCSV.carregarCidades(paisDestino);
            if (cidadesDestino.isEmpty()) {
                System.out.println("Nenhuma cidade encontrada para o pais de destino: " + paisDestino);
                continue;
            }

            // Verifica se as cidades de origem e destino estão na lista
            Cidade cidadeOrigem = null, cidadeDestino = null;

            for (Cidade cidade : cidadesOrigem) {
                if (cidade.getNome().equalsIgnoreCase(cidadeOrigemNome)) {
                    cidadeOrigem = cidade;
                    break;
                }
            }

            for (Cidade cidade : cidadesDestino) {
                if (cidade.getNome().equalsIgnoreCase(cidadeDestinoNome)) {
                    cidadeDestino = cidade;
                    break;
                }
            }

            if (cidadeOrigem == null || cidadeDestino == null) {
                System.out.println("Uma ou ambas as cidades não foram encontradas.");
                continue; // Reinicia o loop para perguntar novamente
            }

            // Solicita a autonomia ao utilizador
            System.out.print("\nDigite a autonomia do automóvel (em km): ");
            int autonomia = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha após o número

            System.out.println("");

            // Chama o método calcularRota para calcular o caminho entre as cidades
            System.out.println("\nCalculando o caminho mais curto entre " + cidadeOrigemNome + " e " + cidadeDestinoNome + "...");
            String resultadoRota = CalcularRota.calcularRota(cidadeOrigemNome, cidadeDestinoNome, autonomia);

            // Exibe o resultado
            System.out.println(resultadoRota);

            // Pergunta ao utilizador se deseja calcular outra rota
            System.out.print("\nDeseja calcular uma nova rota? (sim/nao): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("sim"));

        System.out.println("Obrigado por usar o programa!");
        scanner.close();
    }
}
