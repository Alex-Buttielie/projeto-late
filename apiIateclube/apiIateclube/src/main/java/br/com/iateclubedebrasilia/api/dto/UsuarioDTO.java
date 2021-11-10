package br.com.iateclubedebrasilia.api.dto;

import br.com.iateclubedebrasilia.api.entitys.Grupo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String login;
    private String email;
    private String nome;
    private String senha;
    private Collection<Grupo> gruposUsuario;



}
