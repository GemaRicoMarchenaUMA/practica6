package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Impacto;
import com.example.demo.model.ImpactoService;
import com.example.demo.model.UsuarioService;

@Controller
public class ImpactoViewController {

    @Autowired
    private ImpactoService impactoService;
    
    @Autowired
    private UsuarioService usuarioService; 

    // Ruta usada en el redirect del controller lógico: /impactos/{idUsuario}
    @GetMapping("/impactos/{idUsuario}")
    public String listImpactoView(@PathVariable("idUsuario") Long idUsuario, Model model) {
        
   
        model.addAttribute("impactos", impactoService.getImpactosPorUsuario(idUsuario));
        model.addAttribute("usuario", usuarioService.getUsuario(idUsuario));
        
        return "historialImpactos"; // Nombre del archivo HTML
    }

 
    @GetMapping("/addImpacto/{idUsuario}")
    public String addImpactoView(@PathVariable("idUsuario") Long idUsuario, Model model) {
        
    
        model.addAttribute("impacto", new Impacto());
        model.addAttribute("idUsuario", idUsuario);
        
        return "addImpacto"; // Nombre del archivo HTML
    }
}