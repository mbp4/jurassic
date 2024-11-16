package org.example.jurassic.sensores;

import org.example.jurassic.model.entidades.Dinosaurio;

public class SensorTemperatura {

    public void monitorearTemperatura(Dinosaurio dinosaurio, double temperaturaActual) {
        double minTemp = obtenerTemperaturaMinima(dinosaurio);
        double maxTemp = obtenerTemperaturaMaxima(dinosaurio);

        if (temperaturaActual < minTemp || temperaturaActual > maxTemp) {
            generarAlerta(dinosaurio, temperaturaActual);
        }
    }

    private double obtenerTemperaturaMinima(Dinosaurio dinosaurio) {
        switch (dinosaurio.getTipo().toUpperCase()) {
            case "T-REX":
                return 15.0;
            case "DIPLODOCUS":
                return 10.0;
            default:
                return 12.0;
        }
    }

    private double obtenerTemperaturaMaxima(Dinosaurio dinosaurio) {
        switch (dinosaurio.getTipo().toUpperCase()) {
            case "T-REX":
                return 30.0;
            case "DIPLODOCUS":
                return 25.0;

            default:
                return 28.0;
        }
    }

    private void generarAlerta(Dinosaurio dinosaurio, double temperaturaActual) {
        System.out.println("Alerta: El dinosaurio " + dinosaurio.getNombre() + " está en una temperatura de " + temperaturaActual + "°C, fuera de los límites permitidos.");
    }
}