package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private UsuarioService usuariosService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/salvarUsuario")
    public ResponseEntity<Map<String, Usuario>> salvar(@RequestBody Usuario usuario) {
        return usuariosService.salvar(usuario);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/pesquisarUsuarios")
    public ResponseEntity<List<Usuario>> pesquisarUsuarios(){
        return ResponseEntity.ok().body(usuariosService.listar());
    }

    @GetMapping("/pesquisarUsuario/{id}")
    public ResponseEntity pesquisarUsuario(@PathVariable Integer id){
        return ResponseEntity.ok().body(usuariosService.pesquisarUsuario(id));
    }

    @PutMapping("/alterarUsuarios")
    public List<Usuario> alterarUsuarios(@RequestBody List<Usuario> listaDeUsuarios){
        return usuariosService.alterarUsuarios(listaDeUsuarios);
    }

    @PutMapping("/alterarUsuario/{id}")
    public Usuario alterarUsuario (@RequestBody Usuario usuario, @PathVariable Integer id) {
        return usuariosService.alterarUsuario(usuario, id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Integer id){
        return usuariosService.deletarUsuario(id);
    }

    

}
