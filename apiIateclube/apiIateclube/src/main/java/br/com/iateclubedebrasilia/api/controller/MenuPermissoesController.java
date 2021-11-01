package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.services.MenuPermissoesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menuPermissoesController")
public class MenuPermissoesController {

    @Autowired
    MenuPermissoesServices menuPermissoesServices;
}
