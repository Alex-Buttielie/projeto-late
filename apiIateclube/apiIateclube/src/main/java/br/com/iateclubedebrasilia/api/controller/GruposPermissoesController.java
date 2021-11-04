package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.Grupos;
import br.com.iateclubedebrasilia.api.entitys.GruposPermissoes;
import br.com.iateclubedebrasilia.api.services.GruposPermissoesService;
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
@RequestMapping("/gruposPermissoesController")
public class GruposPermissoesController {

    @Autowired
    GruposPermissoesService gruposPermissoesService;


    @PostMapping("/salvarGruposPermissoes")
    public ResponseEntity<Map<String, GruposPermissoes>> salvar(@RequestBody GruposPermissoes gruposPermissoes) {
        return gruposPermissoesService.salvar(gruposPermissoes);
    }

    @GetMapping("/pesquisarGruposPermissoes")
    public List<GruposPermissoes> pesquisarGrupos(){
        return gruposPermissoesService.listar();
    }

    @GetMapping("/pesquisarGruposPermissoes/{id}")
    public GruposPermissoes pesquisarGrupo(@PathVariable Integer id){
        return gruposPermissoesService.pesquisarGruposPermissoes(id);
    }

    @PutMapping("/alterarGruposPermissoes")
    public List<GruposPermissoes> alterarGrupos(@RequestBody List<GruposPermissoes> listaDeGrupos){
        return gruposPermissoesService.alterarGruposPermissoes(listaDeGrupos);
    }

    @PutMapping("/alterarGruposPermissoes/{id}")
    public  GruposPermissoes alterarGrupo (@RequestBody GruposPermissoes gruposPermissoes, @PathVariable Integer id) {
        return gruposPermissoesService.alterarGruposPermissoes(gruposPermissoes, id);
    }

    @DeleteMapping("/deletarGruposPermissoes/{id}")
    public ResponseEntity deletarGrupo(@PathVariable Integer id){
        return gruposPermissoesService.deletarGruposPermissoes(id);
    }
}
