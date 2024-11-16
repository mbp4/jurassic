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
        if (listado.isEmpty()){
            generarDinosaurios();
        }
        return listado;
    }

        private double obtenerTemperaturaActual() {
            return 20.0; //Ejmeplo de temperatura actual
        }

    public List<Isla> listadoIslas() {
        List<Isla> listado = islaDao.findAll();
        if (listado.isEmpty()){
            generarIslas();
        }
        return listado;
    }

    private void generarIslas() {
        Isla isla1 = new Isla();
        isla1.setNombre("Isla Herviboros");
        isla1.setTipo("Herbívoro");

        Isla isla2 = new Isla();
        isla2.setNombre("Isla Carnivoros");
        isla2.setTipo("Carnívoro");

        islaDao.saveAll(Arrays.asList(isla1, isla2));
    }

    public void generarDinosaurios() {
        Dinosaurio dino1 = new Dinosaurio();
        dino1.setNombre("T-Rex");
        dino1.setAlimentacion("Carnívoro");
        dino1.setTipo("T-Rex");
        dino1.setLugar("Isla de Carnivoros");

        Dinosaurio dino2 = new Dinosaurio();
        dino2.setNombre("Diplodocus");
        dino2.setAlimentacion("Herbívoro");
        dino2.setTipo("Diplodocus");
        dino2.setLugar("Isla de Herviboros");

        Dinosaurio dino3 = new Dinosaurio();
        dino3.setNombre("Velociraptor");
        dino3.setAlimentacion("Carnívoro");
        dino3.setTipo("Velociraptor");
        dino3.setLugar("Isla de Carnivoros");

        Dinosaurio dino4 = new Dinosaurio();
        dino4.setNombre("Stegosaurus");
        dino4.setAlimentacion("Herbívoro");
        dino4.setTipo("Stegosaurus");
        dino4.setLugar("Isla de Herviboros");

        dinosaurioDao.saveAll(Arrays.asList(dino1, dino2, dino3, dino4));
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