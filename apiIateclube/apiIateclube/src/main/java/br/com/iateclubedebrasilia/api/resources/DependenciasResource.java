package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import br.com.iateclubedebrasilia.api.services.DependenciaService;
import br.com.iateclubedebrasilia.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dependencias")
public class DependenciasResource {

    private DependenciaService dependenciaService;

    @Autowired
    private UsuarioService usuariosService;

    public DependenciasResource(DependenciaService dependenciaService, UsuarioService usuariosService) {
        this.dependenciaService = dependenciaService;
        this.usuariosService = usuariosService;
    }

    @GetMapping("/pesquisarUsuarios")
    public ResponseEntity<List<Usuario>> pesquisarUsuarios(){
        List<Usuario> listaUsuarios = usuariosService.listar();
        return ResponseEntity.ok().body(listaUsuarios);
    }


    @GetMapping("/listarChurrasqueiras")
    public ResponseEntity<List<DependenciaDTO>> listarChurrasqueiras(){
        List<DependenciaDTO> dependencias = dependenciaService.listarPorTipo("C");
        return ResponseEntity.ok().body(dependencias);

    }
}
