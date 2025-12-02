package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CascoService {
    
    @Autowired
    private  RepositorioCasco repositorioCasco;

    public List<Casco> getAllCascos() {
        return repositorioCasco.findAll();
    }

    public Casco addCasco(Casco casco) {
        return repositorioCasco.saveAndFlush(casco);
    }

 
}
