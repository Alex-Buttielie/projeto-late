package br.com.iateclubedebrasilia.api.dto;

import br.com.iateclubedebrasilia.api.entitys.Grupo;

import java.util.Collection;

public class UsuarioDTO {

    private Integer id;

    private String Login;

    private String email;

    private String nome;

    private String senha;

    private Collection<Grupo> gruposUsuario;
}
