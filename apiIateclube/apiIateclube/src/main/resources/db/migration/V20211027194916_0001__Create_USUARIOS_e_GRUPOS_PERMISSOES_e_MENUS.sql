CREATE TABLE USUARIOS
(
    USU_IDEN     INT IDENTITY (1,1) PRIMARY KEY,
    USU_LOGIN    VARCHAR(100) UNIQUE NOT NULL,
    USU_NOME     VARCHAR(100) NOT NULL,
    USU_SENHA    VARCHAR(300)        NOT NULL,
    --USU_DTA_HORA TIMESTAMP           NOT NULL,
    USU_USU_IDEN INT,
    CONSTRAINT USU_USU_IDEN FOREIGN KEY (USU_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)

);

CREATE TABLE GRUPOS
(
    GRP_IDEN      INT IDENTITY (1,1)  PRIMARY KEY ,
    GRP_NOME      VARCHAR(255) UNIQUE NOT NULL,
    GRP_DESCRICAO VARCHAR(255),
    --GRP_DTA_HORA  TIMESTAMP           NOT NULL,
    GRP_USU_IDEN  INT                 NOT NULL,
    FOREIGN KEY (GRP_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)
);

CREATE TABLE USUARIOS_GRUPOS
(
    UGR_IDEN INT IDENTITY (1,1)  NOT NULL ,
    UGR_USU_IDEN INT NOT NULL,
    UGR_GRP_IDEN INT NOT NULL,
    --UGR_DTA_HORA TIMESTAMP,
    PRIMARY KEY (UGR_IDEN, UGR_USU_IDEN, UGR_GRP_IDEN),
    FOREIGN KEY (UGR_USU_IDEN)
        REFERENCES GRUPOS (GRP_IDEN),
    FOREIGN KEY (UGR_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)
);

CREATE TABLE PERMISSOES
(
    PER_IDEN      INT IDENTITY (1,1)  PRIMARY KEY,
    PER_DESCRICAO VARCHAR(100),
    PER_NOME      VARCHAR(50) NOT NULL,
    --PER_DTA_HORA  TIMESTAMP   NOT NULL,
    PER_USU_IDEN  INT         NOT NULL,
    FOREIGN KEY (PER_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)
);

CREATE TABLE GRUPOS_PERMISSOES
(
 	GP_IDEN INT IDENTITY (1,1)  NOT NULL,
    GPE_GRP_IDEN INT NOT NULL,
    GPE_PER_IDEN INT NOT NULL,
    PRIMARY KEY (GP_IDEN,GPE_GRP_IDEN, GPE_PER_IDEN),
    FOREIGN KEY (GPE_GRP_IDEN)
        REFERENCES GRUPOS (GRP_IDEN),
    FOREIGN KEY (GPE_PER_IDEN)
        REFERENCES PERMISSOES (PER_IDEN)
);

CREATE TABLE MENUS
(
    MEN_IDEN       INT IDENTITY (1,1)  PRIMARY KEY,
    MEN_DESCRICAO  VARCHAR(255),
    MEN_ICONE      VARCHAR(255),
    MEN_ORDEM_MENU INT,
    MEN_URL        VARCHAR(255),
    MEN_NIVEL      INT       NOT NULL,
    MEN_MEN_IDEN   INT,
    --MEN_DTA_HORA   TIMESTAMP NOT NULL,
    MEN_USU_IDEN   INT,
    FOREIGN KEY (MEN_MEN_IDEN)
        REFERENCES MENUS (MEN_IDEN),
    FOREIGN KEY (MEN_USU_IDEN)
        REFERENCES USUARIOS (USU_IDEN)

);

CREATE TABLE MENU_PERMISSOES
(
	MPE_INDE INT IDENTITY (1,1)  NOT NULL,
    MPE_MEN_IDEN INT NOT NULL,
    MPE_PER_IDEN INT NOT NULL,
    PRIMARY KEY (MPE_INDE,MPE_MEN_IDEN, MPE_PER_IDEN),
    FOREIGN KEY (MPE_MEN_IDEN)
        REFERENCES MENUS (MEN_IDEN),
    FOREIGN KEY (MPE_PER_IDEN)
        REFERENCES PERMISSOES (PER_IDEN)
);


INSERT INTO USUARIOS (USU_LOGIN, USU_NOME, USU_SENHA)
VALUES ('admin', 'Adminstrador do Sistema', '$2a$10$eqELFW4V3UBeBdjbnvnYjOED9Mmyr5WegakP7yfVlhJDalz3aEq1u');

UPDATE USUARIOS
SET USU_USU_IDEN = 1
WHERE USU_LOGIN = 'admin';

--SELECT * FROM USUARIOS

ALTER TABLE USUARIOS
   ALTER COLUMN USU_USU_IDEN int NOT NULL;

insert into GRUPOS (GRP_NOME, GRP_DESCRICAO, GRP_USU_IDEN)
values ('ADMIN', 'GRUPO DE ADMINSTRADORES', (SELECT USU_IDEN FROM USUARIOS WHERE USU_LOGIN = 'admin'));

--SELECT * FROM GRUPOS

insert into GRUPOS (GRP_NOME, GRP_DESCRICAO, GRP_USU_IDEN)
values ('SECRETARIA', 'GRUPO DE SECRETARIA', 1);

--SELECT * FROM GRUPOS

--insert into usuarios_grupos (UGR_USU_IDEN, UGR_GRP_IDEN, UGR_DTA_HORA)
--values (1, 1, SYSDATETIME() );

--SELECT * FROM usuarios_grupos