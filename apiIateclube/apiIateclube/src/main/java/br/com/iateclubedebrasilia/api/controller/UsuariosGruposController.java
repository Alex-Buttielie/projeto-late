package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.UsuariosGrupos;
import br.com.iateclubedebrasilia.api.services.UsuariosGruposService;
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
@RequestMapping("/usuariosGruposController")
public class UsuariosGruposController {

    @Autowired
    UsuariosGruposService usuariosGruposService;


    @PostMapping("/salvarGrupo")
    public ResponseEntity<Map<String, UsuariosGrupos>> salvar(@RequestBody UsuariosGrupos usuariosGrupos) {
        return usuariosGruposService.salvar(usuariosGrupos);
    }

    @GetMapping("/pesquisarGrupos")
    public List<UsuariosGrupos> pesquisarGrupos(){
        return usuariosGruposService.listar();
    }

    @GetMapping("/pesquisarUsuariosGrupos/{id}")
    public UsuariosGrupos pesquisarUsuariosGrupos(@PathVariable Integer id){
        return usuariosGruposService.pesquisarUsuariosGrupos(id);
    }

    @PutMapping("/alterarUsuariosGrupos")
    public List<UsuariosGrupos> alterarUsuariosGrupos(@RequestBody List<UsuariosGrupos> listaDeUsuariosGrupos){
        return usuariosGruposService.alterarUsuariosGrupos(listaDeUsuariosGrupos);
    }

    @PutMapping("/alterarUsuariosGrupos/{id}")
    public  UsuariosGrupos alterarUsuariosGrupos (@RequestBody UsuariosGrupos usuariosGrupos, @PathVariable Integer id) {
        return usuariosGruposService.alterarUsuariosGrupos(usuariosGrupos, id);
    }

    @DeleteMapping("/deletarUsuariosGrupos/{id}")
    public ResponseEntity deletarUsuariosGrupos(@PathVariable Integer id){
        return usuariosGruposService.deletarUsuariosGrupos(id);
    }
}
