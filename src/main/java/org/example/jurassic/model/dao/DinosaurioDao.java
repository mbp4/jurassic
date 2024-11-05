package org.example.jurassic.model.dao;

import org.example.jurassic.model.entidades.Dinosaurio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaurioDao extends JpaRepository<Dinosaurio, Long> {
}
