package br.com.iateclubedebrasilia.api.dto;

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

    //private Collection<AgrupamentoPessoaDTO> agrupamentosPessoasOrigem;

    //private Collection<AgrupamentoPessoaDTO> agrupamentosPessoas;

    private Collection<ContatoPessoaDTO> contatosPessoa;

    private EnderecoPessoaDTO enderecoPessoa;

    private PessoaFisicaDTO pessoaFisica;

    private PessoaJuridicaDTO pessoaJuridica;

    private Boolean status;

    private LocalDateTime dtaHora;

    private Integer usuario;
}
