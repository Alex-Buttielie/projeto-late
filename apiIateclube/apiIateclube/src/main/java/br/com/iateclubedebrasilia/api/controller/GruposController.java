package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.Grupos;
import br.com.iateclubedebrasilia.api.services.GruposService;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gruposController")
public class GruposController{

    @Autowired
    private GruposService gruposService;

    @PostMapping("/salvarGrupo")
    public Grupos salvar(@RequestBody Grupos grupo) throws Exception {
        return gruposService.salvar(grupo);
    }

    @GetMapping("/pesquisarGrupos")
    public List<Grupos> pesquisarGrupos() throws Exception {
        return gruposService.listar();
    }
}
