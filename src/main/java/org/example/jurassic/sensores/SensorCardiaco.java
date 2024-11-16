package org.example.jurassic.sensores;

import org.example.jurassic.model.entidades.Dinosaurio;

public class SensorCardiaco {

    private static final int MIN_HEART_RATE = 30;
    private static final int MAX_HEART_RATE = 120;

    public void monitorearRangoCardiaco(Dinosaurio dinosaurio) {
        int heartRate = dinosaurio.getHeartRate();
        if (heartRate < MIN_HEART_RATE || heartRate > MAX_HEART_RATE) {
            generarAlarma(dinosaurio);
        }
    }

    private void generarAlarma(Dinosaurio dinosaurio) {
        //aviso
        System.out.println("Alarma: El dinosaurio " + dinosaurio.getNombre() + " tiene un rango cardiaco fuera de los límites.");
    }
}