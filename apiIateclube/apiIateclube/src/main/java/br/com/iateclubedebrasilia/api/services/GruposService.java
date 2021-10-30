package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Grupos;

import java.util.List;

public interface GruposService {

    Grupos salvar(Grupos grupo) throws Exception;
    List<Grupos> listar() throws Exception;
}
