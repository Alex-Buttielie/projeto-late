CREATE TABLE USUARIOS
(
    USU_IDEN     INT PRIMARY KEY,
    USU_LOGIN    VARCHAR(100) UNIQUE NOT NULL,
    USU_NOME     VARCHAR(100) NOT NULL ,
    USU_SENHA    VARCHAR(300)        NOT NULL,
    USU_DTA_HORA TIMESTAMP           NOT NULL,
    USU_UGR_IDEN INT,

);

CREATE TABLE GRUPOS
(
    GRP_IDEN      INT PRIMARY KEY,
    GRP_NOME      VARCHAR(255) UNIQUE NOT NULL,
    GRP_DESCRICAO VARCHAR(255),
    GRP_DTA_HORA  TIMESTAMP           NOT NULL,
    GRP_UGR_IDEN  INT                 NOT NULL,

);

CREATE TABLE USUARIOS_GRUPOS
(
    UGR_IDEN INT NOT NULL,
    UGR_USU_IDEN INT NOT NULL,
    UGR_GRP_IDEN INT NOT NULL,
    UGR_DTA_HORA TIMESTAMP,
    PRIMARY KEY (UGR_IDEN, UGR_USU_IDEN, UGR_GRP_IDEN),
    FOREIGN KEY (UGR_GRP_IDEN)
        REFERENCES GRUPOS (GRP_IDEN),
    FOREIGN KEY (UGR_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)
);

CREATE TABLE PERMISSOES
(
    PER_IDEN      INT PRIMARY KEY,
    PER_DESCRICAO VARCHAR(100),
    PER_NOME      VARCHAR(50) NOT NULL,
    PER_DTA_HORA  TIMESTAMP   NOT NULL,
    PER_GP_IDEN  INT         NOT NULL,
);

CREATE TABLE GRUPOS_PERMISSOES
(
    GP_IDEN INT NOT NULL,
    GRP_IDEN INT NOT NULL,
    GRP_PER_IDEN INT NOT NULL,
    PRIMARY KEY (GP_IDEN, GRP_PER_IDEN, GRP_IDEN),
    FOREIGN KEY (GRP_IDEN)
        REFERENCES GRUPOS (GRP_IDEN),
    FOREIGN KEY (GRP_PER_IDEN)
        REFERENCES PERMISSOES (PER_IDEN)
);

CREATE TABLE MENUS
(
    MEN_IDEN       INT PRIMARY KEY,
    MEN_DESCRICAO  VARCHAR(255),
    MEN_ICONE      VARCHAR(255),
    MEN_ORDEM_MENU INT,
    MEN_URL        VARCHAR(255),
    MEN_NIVEL      INT       NOT NULL,
    MEN_MEN_IDEN   INT,
    MEN_DTA_HORA   TIMESTAMP NOT NULL,
    MEN_USU_IDEN   INT,
    FOREIGN KEY (MEN_MEN_IDEN)
        REFERENCES MENUS (MEN_IDEN),
    FOREIGN KEY (MEN_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)

);

CREATE TABLE MENU_PERMISSOES
(
    MPE_MEN_IDEN INT NOT NULL,
    MPE_GRP_IDEN INT NOT NULL,
    PRIMARY KEY (MPE_MEN_IDEN, MPE_GRP_IDEN),
    FOREIGN KEY (MPE_MEN_IDEN)
        REFERENCES MENUS (MEN_IDEN),
    FOREIGN KEY (MPE_GRP_IDEN)
        REFERENCES GRUPOS (GRP_IDEN)
);

INSERT INTO USUARIOS (USU_IDEN, USU_LOGIN, USU_NOME, USU_SENHA, USU_DTA_HORA)
VALUES (1, 'admin', 'Adminstrador do Sistema', '$2a$10$eqELFW4V3UBeBdjbnvnYjOED9Mmyr5WegakP7yfVlhJDalz3aEq1u', SYSDATETIME());

UPDATE USUARIOS
SET USU_UGR_IDEN = 1
WHERE USU_LOGIN = 'admin';

--SELECT * FROM USUARIOS

ALTER TABLE USUARIOS
   ALTER COLUMN USU_UGR_IDEN int NOT NULL;

insert into GRUPOS (GRP_IDEN, GRP_NOME, GRP_DESCRICAO, GRP_DTA_HORA, GRP_UGR_IDEN)
values (1, 'ADMIN', 'GRUPO DE ADMINSTRADORES', SYSDATETIME(), (SELECT USU_IDEN FROM USUARIOS WHERE USU_LOGIN = 'admin'));

insert into GRUPOS (GRP_IDEN, GRP_NOME, GRP_DESCRICAO, GRP_DTA_HORA, GRP_UGR_IDEN)
values (2, 'SECRETARIA', 'GRUPO DE SECRETARIA', SYSDATETIME(), 2);

insert into usuarios_grupos (UGR_USU_IDEN, UGR_GRP_IDEN, UGR_DTA_HORA)
values (1, 1, NOW());