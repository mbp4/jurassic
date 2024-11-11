package org.example.jurassic.model.dao;

import org.example.jurassic.model.entidades.Auditoria;
import org.example.jurassic.model.entidades.Isla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaDao extends JpaRepository<Auditoria, Long> {

}
