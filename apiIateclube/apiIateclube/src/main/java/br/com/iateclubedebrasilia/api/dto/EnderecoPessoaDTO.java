package br.com.iateclubedebrasilia.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPessoaDTO {

    private Integer iden;

    private String tipo;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private String cidade;

    private String estado;

    private String uf;

    @JsonIgnore
    private Boolean status;

    @JsonIgnore
    private LocalDateTime dtaHora;

    @JsonIgnore
    private PessoaDTO pessoa;

    @JsonIgnore
    private Integer usuario;

}
