package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.Permissoes;
import br.com.iateclubedebrasilia.api.services.PermissoesService;
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
@RequestMapping("/permissoesController")
public class PermissoesController {

    @Autowired
    private PermissoesService permissoesService;


    @PostMapping("/salvarGrupo")
    public ResponseEntity<Map<String, Permissoes>> salvar(@RequestBody Permissoes permissoes) {
        return permissoesService.salvar(permissoes);
    }

    @GetMapping("/pesquisarPermissoes")
    public List<Permissoes> pesquisarPermissoes(){
        return permissoesService.listar();
    }

    @GetMapping("/pesquisarPermissao/{id}")
    public Permissoes pesquisarPermissao(@PathVariable Integer id){
        return permissoesService.pesquisarPermissao(id);
    }

    @PutMapping("/alterarPermissoes")
    public List<Permissoes> alterarPermissoes(@RequestBody List<Permissoes> listaDePermissoes){
        return permissoesService.alterarPermissoes(listaDePermissoes);
    }

    @PutMapping("/alterarPermissao/{id}")
    public  Permissoes alterarGrupo (@RequestBody Permissoes grupo, @PathVariable Integer id) {
        return permissoesService.alterarPermissao(grupo, id);
    }

    @DeleteMapping("/deletarPermissao/{id}")
    public ResponseEntity deletarPermissao(@PathVariable Integer id){
        return permissoesService.deletarPermissao(id);
    }
}
