package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.repositorys.PermissoesRepository;
import br.com.iateclubedebrasilia.api.services.PermissoesService;
import br.com.iateclubedebrasilia.api.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissoesServiceImpl implements PermissoesService {

    @Autowired
    private PermissoesRepository permissoesRepository;
}
