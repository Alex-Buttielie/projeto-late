package br.com.iateclubedebrasilia.api.resources;


import br.com.iateclubedebrasilia.api.domain.ReservaDependencia;
import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import br.com.iateclubedebrasilia.api.dto.ReservaDTO;
import br.com.iateclubedebrasilia.api.services.DependenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/listarReservas")
    public ResponseEntity<List<ReservaDependencia>> listarReservasstarChurrasqueiras(){
        List<ReservaDependencia> dependencias = dependenciaService.listarReservas();
        return ResponseEntity.ok().body(dependencias);

    }

    @PostMapping("/reservarChurrasqueira")
    public ResponseEntity<DependenciaDTO> reservarChurrasqueira(@RequestBody ReservaDTO reservaDTO){
        DependenciaDTO dependencia =  dependenciaService.reservarChurrasqueira(reservaDTO);
        return ResponseEntity.ok().body(dependencia);

    }
}
