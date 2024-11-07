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

    //private final List<String> alimentacion = Arrays.asList("HERVIBORO", "OMNIVORO", "PISCIVORO", "CARNIVORO");


    public List<Isla> listadoDinosaurios() {
        List<Isla> listado = islaDao.findAll();
        return listado;
    }

}
