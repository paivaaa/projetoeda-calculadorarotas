package app;

import modelo.CalcularRota;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "sim"; // Inicializar com um valor padrão

        System.out.println("Bem-vindo à Calculadora de Rotas");

        while (continuar.equals("sim")) {
            try {
                // Solicita o nome do país de origem
                System.out.print("Digite o nome do país de origem: ");
                String paisOrigem = scanner.nextLine().trim();

                // Solicita a cidade de origem
                System.out.print("Digite o nome da cidade de origem: ");
                String cidadeOrigemNome = scanner.nextLine().trim();

                // Solicita o nome do país de destino
                System.out.print("Digite o nome do país de destino: ");
                String paisDestino = scanner.nextLine().trim();

                // Solicita a cidade de destino
                System.out.print("Digite o nome da cidade de destino: ");
                String cidadeDestinoNome = scanner.nextLine().trim();

                // Solicita a autonomia do carro
                System.out.print("\nDigite a autonomia do carro (em km): ");
                int autonomia = Integer.parseInt(scanner.nextLine().trim());

                // Chama o método calcularRota da classe CalcularRota
                String resultado = CalcularRota.calcularRota(paisOrigem, cidadeOrigemNome, paisDestino, cidadeDestinoNome, autonomia);

                // Exibe o resultado
                System.out.println(resultado);

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            // Perguntar se o utilizador quer continuar
            System.out.print("\nDeseja realizar outra consulta? (sim/não): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        }

        System.out.println("Obrigado por usar a Calculadora de Rotas!");
        scanner.close();
    }
}
