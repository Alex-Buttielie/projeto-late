package br.com.iateclubedebrasilia.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Integer iden;

    private String nomeReg;

    private String nomeSoc;

    @JsonIgnore
    private Collection<AgrupamentoPessoaDTO> agrupamentosPessoasOrigem;

    @JsonIgnore
    private Collection<AgrupamentoPessoaDTO> agrupamentosPessoas;

    private Collection<ContatoPessoaDTO> contatosPessoa;

    private EnderecoPessoaDTO enderecoPessoa;

    private PessoaFisicaDTO pessoaFisica;

    private PessoaJuridicaDTO pessoaJuridica;

    @JsonIgnore
    private Boolean status;

    @JsonIgnore
    private LocalDateTime dtaHora;

    @JsonIgnore
    private Integer usuario;
}
