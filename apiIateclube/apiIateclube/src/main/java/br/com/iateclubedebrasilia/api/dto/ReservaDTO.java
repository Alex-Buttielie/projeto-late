package br.com.iateclubedebrasilia.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Integer dependencia;
    private String dataLocacao;
    private String periodo;

}
