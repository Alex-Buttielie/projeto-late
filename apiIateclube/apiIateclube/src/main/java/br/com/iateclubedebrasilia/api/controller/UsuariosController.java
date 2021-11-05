package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.Usuario;
import br.com.iateclubedebrasilia.api.services.UsuariosService;
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
@RequestMapping("/usuariosController")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;


    @PostMapping("/salvarUsuario")
    public ResponseEntity<Map<String, Usuario>> salvar(@RequestBody Usuario usuario) {
        return usuariosService.salvar(usuario);
    }

    @GetMapping("/pesquisarUsuarios")
    public ResponseEntity<List<Usuario>> pesquisarUsuarios(){
        List<Usuario> listaUsuarios = usuariosService.listar();
        return ResponseEntity.ok().body(listaUsuarios);
    }

    @GetMapping("/pesquisarUsuario/{id}")
    public Usuario pesquisarUsuario(@PathVariable Integer id){
        return usuariosService.pesquisarUsuario(id);
    }

    @PutMapping("/alterarUsuarios")
    public List<Usuario> alterarUsuarios(@RequestBody List<Usuario> listaDeUsuarios){
        return usuariosService.alterarUsuarios(listaDeUsuarios);
    }

    @PutMapping("/alterarUsuario/{id}")
    public Usuario alterarUsuario (@RequestBody Usuario Usuario, @PathVariable Integer id) {
        return usuariosService.alterarUsuario(Usuario, id);
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Integer id){
        return usuariosService.deletarUsuario(id);
    }
}
