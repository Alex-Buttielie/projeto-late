package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import br.com.iateclubedebrasilia.api.entitys.Dependencia;
import br.com.iateclubedebrasilia.api.repositorys.DependenciaRepository;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DependenciaService {

    private DependenciaRepository dependenciaRepository;

    public DependenciaService(DependenciaRepository dependenciaRepository) {
        this.dependenciaRepository = dependenciaRepository;
    }

    public ResponseEntity salvar(Dependencia dependencia) {
        return Optional
                .ofNullable(dependenciaRepository.save(dependencia))
                .map(dependenciaSalva -> {
                    Map<String, Dependencia> resposta = new HashMap<>();
                    resposta.put("Registro salvo", dependenciaSalva);
                    return ResponseEntity.ok(resposta);
                }).orElseThrow(() -> new NullPointerException("Não foi possível realizar o cadastro!"));
    }

    public List<DependenciaDTO> listar() {
        List<Dependencia> listDependencias = Optional
                .ofNullable(dependenciaRepository.findAll())
                .orElseThrow(() -> new NullPointerException("Não exitem depencncias cadastrados"));
        List<DependenciaDTO> dependenciaDTOList = new ArrayList<>();
        for (Dependencia dep : listDependencias) {

            dependenciaDTOList.add(DependenciaDTO.builder()
                    .id(dep.getSeqDependencia())
                    .descricao(dep.getDescrDependencia())
                    .ativo(dep.getIcAtivo().equals("S") ? true : (dep.getIcAtivo().equals("N") ? false : null))
                    .build());
        }
        return dependenciaDTOList;
    }

    public List<DependenciaDTO> listarPorTipo(String tipoDependencia) {
        List<Dependencia> listDependencias = Optional
                .ofNullable(dependenciaRepository.findAllByIcTipoDependenciaOrderBySeqDependencia(tipoDependencia))
                .orElseThrow(() -> new NullPointerException("Não exitem depencncias deste tipo cadastrados"));

        List<DependenciaDTO> dependenciaDTOList = new ArrayList<>();

        for (Dependencia dep : listDependencias) {
            dependenciaDTOList.add(DependenciaDTO.builder()
                    .id(dep.getSeqDependencia())
                    .descricao(dep.getDescrDependencia())
                    .ativo(dep.getIcAtivo().equals("S") ? true : (dep.getIcAtivo().equals("N") ? false : null))
                    .build());
        }
        return dependenciaDTOList;
    }

    public Dependencia pesquisarDependencia(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado -> dependenciaRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Dependencia não encontrado"));
    }

    public ResponseEntity deletarDependencia(Integer id) {
        return Optional
                .ofNullable(dependenciaRepository.findById(id).orElse(null))
                .map(DependenciaConsultado -> {
                    dependenciaRepository.delete(DependenciaConsultado);
                    return ResponseEntity.ok("Registro excluído");
                }).orElseThrow(() -> new NullPointerException("Dependencia não encontrado para exclusão"));
    }

    public List<Dependencia> alterarDependencias(List<Dependencia> listaDeDependencias) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeDependencias))
                .map(listaValidada -> dependenciaRepository.saveAll(listaDeDependencias))
                .orElseThrow(() -> new NullPointerException("Informe pelo menos um Dependencia para ser alterado"));
    }

    public Dependencia alterarDependencia(Dependencia dependencia, Integer id) {
        return Optional
                .ofNullable(dependenciaRepository.findById(id).orElse(null))
                .map(dependenciaConsultado -> {
                    dependencia.setSeqDependencia(dependenciaConsultado.getSeqDependencia());
                    return dependenciaRepository.save(dependencia);
                }).orElseThrow(() -> new NullPointerException("Não foi possível realizar a alteração"));

    }
}
