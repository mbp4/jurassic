package org.example.jurassic.model.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class Dinosaurio implements Serializable {

    //id autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //alimentacion del dinosaurio: herviboro, carniboro, etc
    @Column(nullable = false)
    private String alimentacion;

    //nombre del dinosaurio
    @Column(nullable = false)
    private String nombre;

    //tipo o familia a la que pertenece el dinosaurio: T-Rex, Diplodocus
    @Column(nullable = false)
    private String tipo;

}
