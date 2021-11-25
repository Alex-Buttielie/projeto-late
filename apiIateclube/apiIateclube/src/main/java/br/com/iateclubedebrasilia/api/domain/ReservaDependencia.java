package br.com.iateclubedebrasilia.api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RESERVA_DEPENDENCIAS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDependencia {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SEQ_RESERVA")
    private Integer seqReserva;

    @JsonFormat
    @ManyToOne
    @JoinColumn(name = "SEQ_DEPENDENCIA", referencedColumnName = "SEQ_DEPENDENCIA")
    private Dependencia dependencia;

    @Column(name = "CD_CATEGORIA")
    private Integer  categoria;

    @Column(name = "CD_MATRICULA")
    private Integer  matricula;

    @Column(name = "SEQ_DEPENDENTE")
    private Integer dependente;

    @Column(name = "DT_INIC_UTILIZACAO")
    private LocalDate inicioUtilizacao;

    @Column(name = "DT_HR_UTILIZACAO")
    private LocalDateTime fimUtilizacao;

    @Column(name = "NOME_INTERESSADO")
    private String nomeInteressado;

    @Column(name = "DT_RESERVA")
    @CreationTimestamp
    private LocalDate dtReserva;

    @Column(name = "DT_CONFIRMACAO")
    private LocalDate dtConfirmacao;

    @Column(name = "TEL_CONTATO")
    private String telContato;

    @Column(name = "CD_STATUS_RESERVA")
    private String isAtivo;

    @Column(name = "DE_CANC_RESERVA")
    private String cancReserva;

    @ManyToOne
    @JoinColumn(name = "DE_USER_CANC", referencedColumnName = "usu_iden")
    private Usuario userCancelaReserva;

    @Column(name = "DT_LIMITE_CONF")
    private LocalDate dtLimiteConfirm;

    @Column(name = "NO_CONTATO")
    private String contato;

    @Column(name = "TEL_CONTATO_RES")
    private String telContatoRes;

    @Column(name = "QT_PUBLICO_PREVISTO")
    private Integer qtPubPrevisto;

    @Column(name = "CD_TIPO_EVENTO")
    private Integer tipoEvento;

    @Column(name = "HH_INIC_UTIL")
    private String hrInicioUtilz;

    @Column(name = "HH_FIM_UTIL")
    private String hrFimUtilz;

    @Column(name = "IC_ORIGEM_RESERVA")
    private String origemReserva;

    @Column(name = "DE_BLOQUEIO")
    private String bloqueio;

    @Column(name = "USER_CONFIRMACAO")
    private String userConfirmacao;


}
