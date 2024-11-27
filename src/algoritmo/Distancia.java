/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author afonso
 */
package algoritmo;

import modelo.*;

public class Distancia {
    
    
    public static double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371; // Raio da Terra em km

        // Converter coordenadas para radianos
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        // Aplicar a fórmula da lei dos cossenos esféricos
        return Math.acos(
                Math.sin(lat1Rad) * Math.sin(lat2Rad) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                Math.cos(lon2Rad - lon1Rad)
        ) * R;
    }
}
