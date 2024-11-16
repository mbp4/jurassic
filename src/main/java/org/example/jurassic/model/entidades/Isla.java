package org.example.jurassic.model.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Isla implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //alimentacion del dinosaurio dividido por isla: herviboro, carniboro, etc
    @Column(nullable = false)
    private String tipo;

    //nombre de la isla
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "nombre", cascade = CascadeType.ALL)
    private List<Dinosaurio> listado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Dinosaurio> getListado() {
        return listado;
    }

    public void setListado(List<Dinosaurio> listado) {
        this.listado = listado;
    }
}
