package br.com.iateclubedebrasilia.api.dto;

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

    private LocalDate dtaIni;

    private Date dtaFim;

    private Boolean status;

    private LocalDateTime dtaHora;

    //private PessoaDTO pessoa;

    private Integer usuario;

}
