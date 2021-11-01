package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.services.UsuariosGruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuariosGruposController")
public class UsuariosGruposController {

    @Autowired
    UsuariosGruposService usuariosGruposService;
}
