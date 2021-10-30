package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.Grupos;
import br.com.iateclubedebrasilia.api.repositorys.GruposRepository;
import br.com.iateclubedebrasilia.api.services.GruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GruposServiceImpl implements GruposService {


    @Autowired
    private GruposRepository gruposRepository;

    @Override
    public Grupos salvar(Grupos grupo) throws Exception {
        return Optional
                .ofNullable(gruposRepository.save(grupo))
                .orElseThrow(()-> new Exception("Não foi possível realizar o cadastro!"));
    }

    @Override
    public List<Grupos> listar() throws Exception {
        return Optional
                .ofNullable(gruposRepository.findAll())
                .orElseThrow(() -> new Exception("Não Exitem Grupos cadastrados"));
    }
}
