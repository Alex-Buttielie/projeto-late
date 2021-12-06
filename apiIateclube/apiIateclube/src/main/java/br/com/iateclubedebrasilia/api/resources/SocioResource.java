package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.dto.PessoaDTO;
import br.com.iateclubedebrasilia.api.services.PessoaService;
import br.com.iateclubedebrasilia.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/socios")
public class SocioResource {

    private PessoaService pessoaService;

    public SocioResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getSocio() {
        PessoaDTO socio = pessoaService.buscarPorId(UserService.authenticated().getId());
        return ResponseEntity.ok().body(socio);

    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaService.salvar(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pessoa.getIden()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

