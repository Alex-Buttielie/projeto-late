package br.com.iateclubedebrasilia.api.dto;

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

    private Boolean status;

    private LocalDateTime dtaHora;

    private PessoaDTO pessoa;

    private Integer usuario;

}
