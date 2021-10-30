package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.repositorys.UsuariosGruposRepository;
import br.com.iateclubedebrasilia.api.services.UsuariosGruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosGruposServiceImpl implements UsuariosGruposService {

    @Autowired
    private UsuariosGruposRepository usuariosGruposRepository;
}
