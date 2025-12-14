package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpactoService {

    @Autowired
    private RepositorioImpacto repositorioImpacto;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Impacto> getAllImpactos() {
        return repositorioImpacto.findAll();
    }

    public Impacto getImpacto(Long id) {
        return repositorioImpacto.getReferenceById(id);
    }

    public Impacto addImpacto(Impacto impacto, Long usuarioId) {
        Usuario usuario = repositorioUsuario.getReferenceById(usuarioId);
        impacto.setUsuario(usuario);
        return repositorioImpacto.saveAndFlush(impacto);
    }

    public void removeImpactoID(Long id) {
        repositorioImpacto.deleteById(id);
    }

    public List<Impacto> getImpactosPorUsuario(Long usuarioId) {
        return repositorioImpacto.findByUsuarioId(usuarioId);
    }
}