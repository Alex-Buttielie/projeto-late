package br.com.iateclubedebrasilia.api.resources;


import br.com.iateclubedebrasilia.api.domain.ReservaDependencia;
import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import br.com.iateclubedebrasilia.api.dto.ReservaDTO;
import br.com.iateclubedebrasilia.api.services.DependenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/dependencias")
public class DependenciasResource {

    private DependenciaService dependenciaService;

    public DependenciasResource(DependenciaService dependenciaService) {
        this.dependenciaService = dependenciaService;
    }

    @GetMapping("/listarChurrasqueiras")
    public ResponseEntity<List<DependenciaDTO>> listarChurrasqueiras() {
        List<DependenciaDTO> dependencias = dependenciaService.listarPorTipo("C");
        return ResponseEntity.ok().body(dependencias);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarDependencias(
            @RequestParam(value = "tipo", defaultValue = "churrasqueira") String tipo,
            @RequestParam(value = "dataLocacao", defaultValue = "") String dataLocacao) {

        List<DependenciaDTO> churrasqueiras = dependenciaService.listarDependencias(tipo, dataLocacao);

        return ResponseEntity.ok().body(churrasqueiras);
    }

    @GetMapping("/reservas")
    public ResponseEntity<?> listarReservas() {
        List<ReservaDependencia> dependencias = dependenciaService.listarReservas();
        return ResponseEntity.ok().body(dependencias);

    }

    @PostMapping("/reservas")
    public ResponseEntity<?> reservar(@RequestBody ReservaDTO reservaDTO) {

        ReservaDependencia reservaDependencia = dependenciaService.reservar(reservaDTO);
        Map<String, String> resposta = new HashMap<>();
        resposta.put("Registro salvo", "Número da reserva: " + reservaDependencia.getIden());
        return ResponseEntity.ok(resposta);

    }
}
