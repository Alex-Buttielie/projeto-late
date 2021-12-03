package br.com.iateclubedebrasilia.api.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDTO {

    private Integer iden;

    private Character sexo;

    private LocalDate dtaNascimento;

    private String naturalidade;

    private String nacionalidade;

    private String estCivil;

    private String cpf;

    private String rg;

    private String rgOrgEmissor;

    private LocalDate dtaEmissao;

    private String nomeMae;

    private String nomePai;

    private PessoaDTO pessoa;

    private Boolean status;

    private LocalDateTime dtaHora;

    private Integer usuario;

}
