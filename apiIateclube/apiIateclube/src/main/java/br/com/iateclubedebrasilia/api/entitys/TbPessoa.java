package br.com.iateclubedebrasilia.api.entitys;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Table(name = "TB_Pessoa")
@Entity
public class TbPessoa {
    @EmbeddedId
    private TbPessoaId id;

    @Column(name = "CD_TP_DEPENDENTE")
    private Integer cdTpDependente;

    @Column(name = "NOME_PESSOA", nullable = false, length = 40)
    private String nomePessoa;

    @Column(name = "DT_NASCIMENTO")
    private Date dtNascimento;

    @Column(name = "CD_SEXO")
    private Character cdSexo;

    @Column(name = "CD_SIT_PESSOA", length = 2)
    private String cdSitPessoa;

    @Column(name = "DT_INIC_SIT_PESSOA")
    private Date dtInicSitPessoa;

    @Column(name = "DT_FIM_SIT_PESSOA")
    private Date dtFimSitPessoa;

    @Column(name = "DT_CADASTRAMENTO_TITULO")
    private Date dtCadastramentoTitulo;

    @Column(name = "NR_CARTEIRA_PESSOA", nullable = false, precision = 10)
    private BigDecimal nrCarteiraPessoa;

    @Column(name = "DT_VENC_CARTEIRA")
    private Date dtVencCarteira;

    @Column(name = "NR_CARTEIRAS_EMITIDAS")
    private Integer nrCarteirasEmitidas;

    @Column(name = "DT_VALID_EX_MEDICO_PESSOA")
    private Date dtValidExMedicoPessoa;

    @Column(name = "CD_CASO_ESPECIAL")
    private String cdCasoEspecial;

    @Column(name = "CD_DEP_ISENTO")
    private String cdDepIsento;

    @Column(name = "DT_INCL_PESSOA")
    private Date dtInclPessoa;

    @Column(name = "DT_EMISSAO_CARTEIRA")
    private Date dtEmissaoCarteira;

    @Column(name = "USER_EMITIU_CARTEIRA", length = 12)
    private String userEmitiuCarteira;

    @Column(name = "CD_CARGO_ESPECIAL")
    private Integer cdCargoEspecial;

    @Column(name = "CD_CARGO_ATIVO")
    private String cdCargoAtivo;

    @Column(name = "DT_VALID_RET_CONVITE")
    private Date dtValidRetConvite;

    @Column(name = "DT_CASO_ESPECIAL")
    private Date dtCasoEspecial;

    @Column(name = "DT_VALID_RESERVA")
    private Date dtValidReserva;

    @Column(name = "QT_ENTRADAS")
    private Integer qtEntradas;

    @Column(name = "DT_VALID_MATERIAL")
    private Date dtValidMaterial;

    @Column(name = "DT_ULT_ATUALIZACAO_SITE")
    private Date dtUltAtualizacaoSite;

    @Column(name = "DE_EMAIL", length = 50)
    private String deEmail;

    @Column(name = "QT_ENTRADA_CARTEIRA_VENCIDA")
    private Integer qtEntradaCarteiraVencida;

    @Column(name = "DT_ULT_ATU_INTERNET")
    private Date dtUltAtuInternet;

    @Column(name = "DT_ENTREGA_BRINDE")
    private Date dtEntregaBrinde;

    @Column(name = "IC_EMP_TODOS_MAT")
    private String icEmpTodosMat;

    @Column(name = "IC_TX_IND_TODAS_TX")
    private String icTxIndTodasTx;

    @Column(name = "CD_MATRICULA_ORIGINAL")
    private Integer cdMatriculaOriginal;

    @Column(name = "CD_CATEGORIA_ORIGINAL")
    private Integer cdCategoriaOriginal;

}