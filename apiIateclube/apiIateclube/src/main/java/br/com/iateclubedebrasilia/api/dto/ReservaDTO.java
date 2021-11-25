package br.com.iateclubedebrasilia.api.dto;

import br.com.iateclubedebrasilia.api.domain.Dependencia;
import br.com.iateclubedebrasilia.api.domain.ReservaDependencia;
import br.com.iateclubedebrasilia.api.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Dependencia dependencia;
    private Usuario usuario;
    private ReservaDependencia reserva;

}
