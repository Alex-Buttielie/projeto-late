package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.repositorys.MenuPermissoesRepository;
import br.com.iateclubedebrasilia.api.services.MenuPermissoesServices;
import br.com.iateclubedebrasilia.api.services.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuPermissoesServiceImpl implements MenuPermissoesServices {

    @Autowired
    private MenuPermissoesRepository menuPermissoesRepository;
}
