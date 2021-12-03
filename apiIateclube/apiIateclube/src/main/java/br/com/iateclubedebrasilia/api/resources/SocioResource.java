package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.domain.Pessoa;
import br.com.iateclubedebrasilia.api.dto.PessoaDTO;
import br.com.iateclubedebrasilia.api.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/socios")
public class SocioResource {

    private PessoaService pessoaService;

    public SocioResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PessoaDTO pessoaDTO) {

        Pessoa pessoa = pessoaService.salvar(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pessoa.getIden()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

