package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Impacto;
import com.example.demo.model.ImpactoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
// Sin @RequestMapping arriba, para que sea simple
public class ImpactoController {

    @Autowired
    private ImpactoService impactoService;

    @PostMapping("/impacto")
    public void saveImpacto(HttpServletResponse response, Impacto impacto, @RequestParam("idUsuario") Long idUsuario) throws IOException {
        try {
            impactoService.addImpacto(impacto, idUsuario);
            // Al terminar, volvemos a la página del historial del usuario
            response.sendRedirect("/impactos/" + idUsuario); 
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
            response.sendRedirect("/listUsuario");
        }
    }
    @DeleteMapping("/impacto/{id}")
    public void deleteImpacto(HttpServletResponse response, 
                              @PathVariable("id") Long idImpacto, 
                              @RequestParam("idUsuario") Long idUsuario) throws IOException { // <--- AÑADIDO ESTO
        try {
            impactoService.removeImpactoID(idImpacto);
            response.sendRedirect("/impactos/" + idUsuario); 

        } catch (Exception e) {
            System.out.println("Error eliminando: " + e.getMessage());
            response.sendRedirect("/listUsuario"); 
        }
    }
}