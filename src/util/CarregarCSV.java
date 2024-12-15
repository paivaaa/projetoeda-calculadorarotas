/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tiago Paiva e Mário Bonacho
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidade;

public class CarregarCSV {
    public static List<Cidade> carregarCidades(String paisEscolhido) {
        String filePath = "src/resources/worldcities.csv"; // Caminho para o ficheiro CSV
        List<Cidade> cidades = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
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
}



