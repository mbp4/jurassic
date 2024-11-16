package org.example.jurassic.servicios;

import org.example.jurassic.model.dao.DinosaurioDao;
import org.example.jurassic.model.dao.IslaDao;
import org.example.jurassic.model.entidades.Dinosaurio;
import org.example.jurassic.model.entidades.Isla;
import org.example.jurassic.sensores.SensorCardiaco;
import org.example.jurassic.sensores.SensorTemperatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OperacionesServicio {

    @Autowired
    private DinosaurioDao dinosaurioDao;

    @Autowired
    private IslaDao islaDao;

    private final List<String> alimentacion = Arrays.asList("HERVIBORO", "OMNIVORO", "PISCIVORO", "CARNIVORO");

    private final SensorCardiaco sensorCardiaco = new SensorCardiaco();
    private final SensorTemperatura sensorTemperatura = new SensorTemperatura();

    public List<Dinosaurio> listadoDinosaurios() {
        List<Dinosaurio> listado = dinosaurioDao.findAll();
        for (Dinosaurio dinosaurio : listado) {
            sensorCardiaco.monitorearRangoCardiaco(dinosaurio);
            double temperaturaActual = obtenerTemperaturaActual();
            sensorTemperatura.monitorearTemperatura(dinosaurio, temperaturaActual);
        }
        return listado;
    }

    private double obtenerTemperaturaActual() {
        return 20.0; //Ejmeplo de temperatura actual
    }

    public List<Isla> listadoIslas() {
        List<Isla> listado = islaDao.findAll();
        return listado;
    }

    public int guardarDinosaurio(Dinosaurio dinosaurio) {
        int result = 0;
        if (!alimentacion.contains(dinosaurio.getAlimentacion().toUpperCase())) {
            result = 1;
        }

        if (result == 0) {
            dinosaurioDao.save(dinosaurio);
        }

        return result;
    }
}