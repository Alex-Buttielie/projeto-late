package br.com.iateclubedebrasilia.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenciaDTO {

    private Integer id;
    private String descricao;
    private Boolean ativo;
    private String periodo;
    private String mes;
    private Integer dia;

}
