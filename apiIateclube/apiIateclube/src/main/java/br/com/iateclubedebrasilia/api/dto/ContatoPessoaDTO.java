package br.com.iateclubedebrasilia.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoPessoaDTO {

    private Integer iden;

    private String tipo;

    private Boolean principal;

    private String contato;

    private String observacao;

    @JsonIgnore
    private LocalDate dtaIni;

    @JsonIgnore
    private Date dtaFim;

    @JsonIgnore
    private Boolean status;

    @JsonIgnore
    private LocalDateTime dtaHora;

    @JsonIgnore
    private PessoaDTO pessoa;

    @JsonIgnore
    private Integer usuario;

}
