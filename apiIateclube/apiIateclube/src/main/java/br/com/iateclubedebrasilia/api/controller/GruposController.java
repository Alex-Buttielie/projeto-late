package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.Grupos;
import br.com.iateclubedebrasilia.api.services.GruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gruposController")
public class GruposController{

    @Autowired
    private GruposService gruposService;

    @PostMapping("/salvarGrupo")
    public ResponseEntity<Map<String, Grupos>> salvar(@RequestBody Grupos grupo) {
        return gruposService.salvar(grupo);
    }

    @GetMapping("/pesquisarGrupos")
    public List<Grupos> pesquisarGrupos(){
        return gruposService.listar();
    }

    @GetMapping("/pesquisarGrupo/{id}")
    public Grupos pesquisarGrupo(@PathVariable Integer id){
        return gruposService.pesquisarGrupo(id);
    }

    @PutMapping("/alterarGrupos")
    public List<Grupos> alterarGrupos(@RequestBody List<Grupos> listaDeGrupos){
        return gruposService.alterarGrupos(listaDeGrupos);
    }

    @PutMapping("/alterarGrupo/{id}")
    public  Grupos alterarGrupo (@RequestBody Grupos grupo, @PathVariable Integer id) {
        return gruposService.alterarGrupo(grupo, id);
    }

    @DeleteMapping("/deletarGrupo/{id}")
    public ResponseEntity deletarGrupo(@PathVariable Integer id){
        return gruposService.deletarGrupo(id);
    }

}
