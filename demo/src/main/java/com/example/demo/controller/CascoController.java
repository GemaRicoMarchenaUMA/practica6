package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Casco;
import com.example.demo.model.CascoService;

@RestController
public class CascoController {
    @Autowired
    private CascoService cascoService;
    
    @GetMapping("/cascos")
    public List<Casco> getAllCascos() {
        return cascoService.getAllCascos();
    }

    @PostMapping("/cascos")
    public ResponseEntity<?> addCasco(@RequestBody Casco c) {
        try {
            cascoService.addCasco(c);
            return ResponseEntity.ok().body("El casco se ha añadido");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("El casco ya existe");
        }
    }
}