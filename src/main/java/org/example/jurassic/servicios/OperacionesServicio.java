package org.example.jurassic.servicios;

import org.example.jurassic.model.dao.DinosaurioDao;
import org.example.jurassic.model.dao.IslaDao;
import org.example.jurassic.model.entidades.Dinosaurio;
import org.example.jurassic.model.entidades.Isla;
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


    public List<Dinosaurio> listadoDinosaurios() {
        List<Dinosaurio> listado = dinosaurioDao.findAll();
        if (listado.isEmpty()){
            generarDinosaurios();
        }
        return listado;
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

    public void asignar(Dinosaurio dinosaurio){
        List<Isla> islasGuardadas = islaDao.findAll();

        Isla islaDestino = null;

        for (Isla isla : islasGuardadas) {
            if ("Herbívoro".equalsIgnoreCase(dinosaurio.getAlimentacion()) && "Herbívoro".equalsIgnoreCase(isla.getTipo())) {
                islaDestino = isla;
                break;
            } else if ("Carnívoro".equalsIgnoreCase(dinosaurio.getAlimentacion()) && "Carnívoro".equalsIgnoreCase(isla.getTipo())) {
                islaDestino = isla;
                break;
            }
        }

        if (islaDestino != null) {
            dinosaurio.setLugar(islaDestino.getNombre());
            islaDestino.getListado().add(dinosaurio);
            islaDao.save(islaDestino);
            dinosaurioDao.save(dinosaurio);
        } else {
            throw new RuntimeException("No se encontró una isla adecuada para el dinosaurio");
        }
    }

    public int guardarDinosaurio(Dinosaurio dinosaurio) {
        int result = 0;
        if (!dinosaurio.getAlimentacion().equals(alimentacion)) {
            result = 1;
        }

        if (result == 0) {
            dinosaurioDao.save(dinosaurio);
        }

        return result;
    }
}
