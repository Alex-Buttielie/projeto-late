package br.com.iateclubedebrasilia.api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridicaDTO {

    private Integer iden;

    private String cnpj;

    private String insMuni;

    private String insEst;

    private Boolean indFornecedor;

    private PessoaDTO pessoa;

    private Boolean status;

    private LocalDateTime dtaHora;

    private Integer usuario;

}
