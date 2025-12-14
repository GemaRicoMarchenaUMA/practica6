package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioImpacto extends JpaRepository<Impacto, Long> {

    List<Impacto> findByUsuarioId(Long usuarioId);
}