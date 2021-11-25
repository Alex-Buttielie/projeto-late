package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import br.com.iateclubedebrasilia.api.services.DependenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dependencias")
public class DependenciasResource {

    private DependenciaService dependenciaService;

    public DependenciasResource(DependenciaService dependenciaService) {
        this.dependenciaService = dependenciaService;
    }

    @GetMapping("/listarChurrasqueiras")
    public ResponseEntity<List<DependenciaDTO>> listarChurrasqueiras(){
        List<DependenciaDTO> dependencias = dependenciaService.listarPorTipo("C");
        return ResponseEntity.ok().body(dependencias);

    }
}
