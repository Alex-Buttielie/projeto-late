package br.com.iateclubedebrasilia.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private PessoaDTO pessoa;

    @JsonIgnore
    private Boolean status;

    @JsonIgnore
    private LocalDateTime dtaHora;

    @JsonIgnore
    private Integer usuario;

}
