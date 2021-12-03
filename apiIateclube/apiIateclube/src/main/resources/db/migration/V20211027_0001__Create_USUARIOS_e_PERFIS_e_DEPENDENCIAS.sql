CREATE TABLE USUARIOS
(
    USU_IDEN     INT IDENTITY (1,1) PRIMARY KEY,
    USU_EMAIL    VARCHAR(300) UNIQUE NOT NULL,
    USU_NOME     VARCHAR(100)        NOT NULL,
    USU_SENHA    VARCHAR(300)        NOT NULL,
    USU_CPF_CNPJ VARCHAR(11)         NOT NULL,
    USU_TIPO     INTEGER,
    USU_DTA_HORA DATETIME default getdate(),
    USU_USU_IDEN INT,
    CONSTRAINT USU_USU_IDEN_FK FOREIGN KEY (USU_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)

);

CREATE TABLE PERFIS
(
    USUARIO_USU_IDEN INT NOT NULL,
    PERFIS           INT
        FOREIGN KEY (USUARIO_USU_IDEN)
            REFERENCES USUARIOS (USU_IDEN)
);

CREATE TABLE DEPENDENCIAS
(
    DEP_IDEN             INT IDENTITY (1,1) PRIMARY KEY,
    DEP_DESCRICAO        VARCHAR(300) NOT NULL,
    DEP_ABREVIACAO       VARCHAR(100) NOT NULL,
    DEP_TIPO_DEPENDENCIA VARCHAR(10)  NOT NULL,
    DEP_STATUS           VARCHAR(2)   NOT NULL,
    DEP_DTA_HORA         DATETIME default getdate(),
    DEP_USU_IDEN         INT,
    CONSTRAINT DEP_USU_IDEN_FK FOREIGN KEY (DEP_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)

);

CREATE TABLE RESERVAS_DEPENDENCIAS
(
    RDEP_IDEN            INT IDENTITY (1,1) PRIMARY KEY,
    RDEP_USU_SOLICITANTE INT      NOT NULL,
    RDEP_DEP_IDEN        INT      NOT NULL,
    RDEP_DTA_HORA_INICIO DATETIME NOT NULL,
    RDEP_DTA_HORA_FIM    DATETIME NOT NULL,
    RDEP_DTA_HORA        DATETIME default getdate(),
    CONSTRAINT RDEP_USU_SOL_FK FOREIGN KEY (RDEP_USU_SOLICITANTE)
        REFERENCES USUARIOS (USU_IDEN),
    CONSTRAINT RDEP_DEP_IDEN_FK FOREIGN KEY (RDEP_DEP_IDEN)
        REFERENCES DEPENDENCIAS (DEP_IDEN)
);

INSERT INTO USUARIOS (USU_EMAIL, USU_NOME, USU_SENHA, USU_CPF_CNPJ)
VALUES ('admin@admin.com.br', 'Adminstrador do Sistema',
        '$2a$10$vWpn9CIUywqDzxgPVzkENuiDRH9HMnEhROueeFAcmk2iayJzFXF8a', '70846792192'); --7332g9xyOd

UPDATE USUARIOS
SET USU_USU_IDEN = 1
WHERE USU_EMAIL = 'admin@admin.com.br';


ALTER TABLE USUARIOS
    ALTER COLUMN USU_USU_IDEN int NOT NULL;


insert into PERFIS (USUARIO_USU_IDEN, PERFIS)
values (1, 1);

INSERT DEPENDENCIAS (DEP_DESCRICAO, DEP_ABREVIACAO, DEP_TIPO_DEPENDENCIA, DEP_STATUS, DEP_DTA_HORA, DEP_USU_IDEN)
SELECT tbd.DESCR_DEPENDENCIA, tbd.DE_ABREVIACAO, tbd.IC_TIPO_DEPENDENCIA, tbd.IC_ATIVO, getdate(), 1
FROM TB_Dependencia tbd
WHERE tbd.IC_TIPO_DEPENDENCIA = 'C'
ORDER BY 1;

