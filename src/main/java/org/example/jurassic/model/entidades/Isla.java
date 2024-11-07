package org.example.jurassic.model.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
public class Isla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //nombre de la isla
    @Column(nullable = false)
    private String nombre;

    //carnivoro, herviboro, etc
    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private List<Dinosaurio> dinosaurios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Dinosaurio> getDinosaurios() {
        return dinosaurios;
    }

    public void setDinosaurios(List<Dinosaurio> dinosaurios) {
        this.dinosaurios = dinosaurios;
    }
}
