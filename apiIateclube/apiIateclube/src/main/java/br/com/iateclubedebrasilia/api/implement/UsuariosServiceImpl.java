package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.repositorys.UsuariosRepository;
import br.com.iateclubedebrasilia.api.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private   UsuariosRepository usuariosRepository;
}
