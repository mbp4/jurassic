package org.example.jurassic.servicios;

import org.example.jurassic.model.dao.DinosaurioDao;
import org.example.jurassic.model.entidades.Dinosaurio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionesServicio {

    @Autowired
    private DinosaurioDao dinosaurioDao;

    //private final List<String> alimentacion = Arrays.asList("HERVIBORO", "OMNIVORO", "PISCIVORO", "CARNIVORO");


        public List<Dinosaurio> listadoDinosaurios() {
        List<Dinosaurio> listado = dinosaurioDao.findAll();
        return listado;
        }

}
