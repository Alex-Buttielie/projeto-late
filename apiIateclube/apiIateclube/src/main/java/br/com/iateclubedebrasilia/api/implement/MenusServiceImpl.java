package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.repositorys.MenusRepository;
import br.com.iateclubedebrasilia.api.services.MenusService;
import br.com.iateclubedebrasilia.api.services.PermissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private MenusRepository menusRepository;
}
