package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.Dependencia;
import br.com.iateclubedebrasilia.api.domain.ReservaDependencia;
import br.com.iateclubedebrasilia.api.dto.DependenciaDTO;
import br.com.iateclubedebrasilia.api.dto.ReservaDTO;
import br.com.iateclubedebrasilia.api.repositories.DependenciaRepository;
import br.com.iateclubedebrasilia.api.repositories.ReservaDependenciaRepository;
import br.com.iateclubedebrasilia.api.repositories.impl.DependenciasRepositoryImpl;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import br.com.iateclubedebrasilia.api.services.exceptions.ValidationException;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DependenciaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DependenciaRepository dependenciaRepository;

    @Autowired
    private DependenciasRepositoryImpl dependenciasRepositoryImpl;

    @Autowired
    private ReservaDependenciaRepository reservaDependenciaRepository;

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
                    .iden(dep.getIden())
                    .descricao(dep.getDescricao())
                    .abreviacao(dep.getAbreviacao())
                    .diurno("")
                    .build());
        }
        return dependenciaDTOList;
    }

    public List<DependenciaDTO> listarPorTipo(String tipoDependencia) {
        /**
         * ESSE MÉTODO SERÁ USADO QUANDO ESTIVER COM DADOS PERSISTIDOS NO BANDO DE DADOS
         *
         * List<Dependencia> listDependencias = Optional
         .ofNullable(dependenciaRepository.findAllByIcTipoDependenciaOrderBySeqDependencia(tipoDependencia))
         .orElseThrow(() -> new NullPointerException("Não exitem depencncias deste tipo cadastrados"));*/

        List<Dependencia> listDependencias = Optional
                .ofNullable(new ArrayList<Dependencia>())
                .orElseThrow(() -> new NullPointerException("Não existem dependencias cadastradas"));

        List<DependenciaDTO> dependenciaDTOList = new ArrayList<>();

        for (Dependencia dep : listDependencias) {
            dependenciaDTOList.add(DependenciaDTO.builder()
                    .iden(dep.getIden())
                    .descricao(dep.getDescricao())
                    .abreviacao(dep.getAbreviacao())
                    .diurno("")
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
                    dependencia.setIden(dependenciaConsultado.getIden());
                    return dependenciaRepository.save(dependencia);
                }).orElseThrow(() -> new NullPointerException("Não foi possível realizar a alteração"));

    }

    public ReservaDependencia reservar(ReservaDTO reservaDTO) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        Dependencia dep = dependenciaRepository.findById(reservaDTO.getDependencia()).get();

        LocalDateTime dataInicio = LocalDateTime.parse(
                reservaDTO.getDataLocacao() + " "
                        + (reservaDTO.getPeriodo().equals("diurno") ? "09:00:00.000" : "18:00:00.000"), formatter);
        LocalDateTime dataFim = LocalDateTime.parse(
                reservaDTO.getDataLocacao() + " "
                        + (reservaDTO.getPeriodo().equals("diurno") ? "18:00:00.000" : "22:00:00.000"), formatter);

        ReservaDependencia consulta = reservaDependenciaRepository.findByDependenciaAndDtaHoraInicio(dep, dataInicio);
        if (consulta != null){
            throw new ValidationException("Dependência já reservada para esta data!");
        }

        ReservaDependencia reservaDependencia = ReservaDependencia
                .builder()
                .dependencia(dep)
                .dtaHoraInicio(dataInicio)
                .dtaHoraFim(dataFim)
                .dtaHora(LocalDateTime.now())
                .usuario(usuarioService.find(UserService.authenticated().getId()))
                .build();

        return Optional
                .ofNullable(reservaDependencia)
                .map(r -> reservaDependenciaRepository.save(r))
                .orElseThrow(() -> new RuntimeException("Ocorreu algum erro na reserva da churrasqueia"));

    }

    public List<ReservaDependencia> listarReservas() {
        return reservaDependenciaRepository.findAll();
    }

    public List<DependenciaDTO> listarDependencias(String tipo, String dataInicio) {

        switch (tipo){
            case "churrasqueira":
                tipo = "C";
                break;
            default:
                tipo = "C";
                break;
        }

        LocalDate ldDataInicio;

        if (dataInicio.isEmpty()){
            ldDataInicio = LocalDate.now();
        } else {
            ldDataInicio = LocalDate.parse(dataInicio);
        }

        if (ldDataInicio.isBefore(LocalDate.now())) {
            throw new ValidationException("Data início menor que data atual");
        }

        List<DependenciaDTO> dependenciaDTOList = Optional
                .ofNullable(dependenciasRepositoryImpl.listarDependencias(tipo, ldDataInicio))
                .orElseThrow(() -> new ObjectNotFoundException("Não exitem churrasqueiras cadastradas"));

        return dependenciaDTOList;
    }
}
