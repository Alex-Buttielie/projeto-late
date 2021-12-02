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

    private int iden;
    private String abreviacao;
    private String descricao;
    private String diurno;
    private String noturno;

}
