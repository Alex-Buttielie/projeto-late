package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.entitys.Grupo;
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
    public ResponseEntity<Map<String, Grupo>> salvar(@RequestBody Grupo grupo) {
        return gruposService.salvar(grupo);
    }

    @GetMapping("/pesquisarGrupos")
    public List<Grupo> pesquisarGrupos(){
        return gruposService.listar();
    }

    @GetMapping("/pesquisarGrupo/{id}")
    public Grupo pesquisarGrupo(@PathVariable Integer id){
        return gruposService.pesquisarGrupo(id);
    }

    @PutMapping("/alterarGrupos")
    public List<Grupo> alterarGrupos(@RequestBody List<Grupo> listaDeGrupos){
        return gruposService.alterarGrupos(listaDeGrupos);
    }

    @PutMapping("/alterarGrupo/{id}")
    public Grupo alterarGrupo (@RequestBody Grupo grupo, @PathVariable Integer id) {
        return gruposService.alterarGrupo(grupo, id);
    }

    @DeleteMapping("/deletarGrupo/{id}")
    public ResponseEntity deletarGrupo(@PathVariable Integer id){
        return gruposService.deletarGrupo(id);
    }

}
