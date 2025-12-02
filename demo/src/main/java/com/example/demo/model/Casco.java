package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Casco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean estadoConexion;
    private String nivelBateria;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isEstadoConexion() {
        return estadoConexion;
    }
    public void setEstadoConexion(boolean estadoConexion) {
        this.estadoConexion = estadoConexion;
    }
    public String getNivelBateria() {
        return nivelBateria;
    }
    public void setNivelBateria(String nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    
}
