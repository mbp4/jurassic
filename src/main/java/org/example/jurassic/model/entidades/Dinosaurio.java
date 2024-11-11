package org.example.jurassic.model.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
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

    @Column(nullable = false)
    private String lugar;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
//definimos getter y setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
