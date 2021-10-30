package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.repositorys.GruposPermissoesRepository;
import br.com.iateclubedebrasilia.api.services.GruposPermissoesService;
import br.com.iateclubedebrasilia.api.services.MenuPermissoesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GruposPermissoesServiceImpl implements GruposPermissoesService {

    @Autowired
    private GruposPermissoesRepository gruposPermissoesRepository;
}
