-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-06-07 01:43:37.589




-- tables
-- Table: fazenda
CREATE TABLE fazenda (
    id int  NOT NULL,
    nome varchar(30)  NULL,
    qtd_alqueires int  NULL,
    dt_inclusao timestamp  NOT NULL,
    dt_modificacao timestamp  NOT NULL,
    CONSTRAINT fazenda_pk PRIMARY KEY (id)
);



-- Table: idade
CREATE TABLE idade (
    id int  NOT NULL,
    descricao varchar(50)  NULL,
    CONSTRAINT idade_pk PRIMARY KEY (id)
);



-- Table: lote_gado
CREATE TABLE lote_gado (
    id int  NOT NULL,
    qtd_gado int  NULL,
    sexo char(1)  NOT NULL,
    qtd_arrobas int  NOT NULL,
    valor_arroba real  NOT NULL,
    dt_modificacao timestamp  NULL,
    dt_inclusao timestamp  NULL,
    fazenda_id int  NOT NULL,
    raca_gado_id int  NOT NULL,
    idade_id int  NOT NULL,
    CONSTRAINT lote_gado_pk PRIMARY KEY (id)
);



-- Table: movimentacao_gado
CREATE TABLE movimentacao_gado (
    id int  NOT NULL,
    qtd_gado int  NULL,
    qtd_arrobas int  NOT NULL,
    sexo char(1)  NULL,
    valor_arroba real  NOT NULL,
    dt_inclusao timestamp  NOT NULL,
    dt_modificacao int  NOT NULL,
    tipo_movimentacao_id int  NOT NULL,
    lote_gado_id int  NOT NULL,
    CONSTRAINT movimentacao_gado_pk PRIMARY KEY (id)
);



-- Table: raca_gado
CREATE TABLE raca_gado (
    id int  NOT NULL,
    nome varchar(30)  NULL,
    CONSTRAINT raca_gado_pk PRIMARY KEY (id)
);



-- Table: tipo_movimentacao
CREATE TABLE tipo_movimentacao (
    id int  NOT NULL,
    descricao varchar(50)  NULL,
    dt_inclusao timestamp  NOT NULL,
    dt_modificacao timestamp  NOT NULL,
    CONSTRAINT tipo_movimentacao_pk PRIMARY KEY (id)
);







-- foreign keys
-- Reference:  lote_gado_fazenda (table: lote_gado)


ALTER TABLE lote_gado ADD CONSTRAINT lote_gado_fazenda 
    FOREIGN KEY (fazenda_id)
    REFERENCES fazenda (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  lote_gado_idade (table: lote_gado)


ALTER TABLE lote_gado ADD CONSTRAINT lote_gado_idade 
    FOREIGN KEY (idade_id)
    REFERENCES idade (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  lote_gado_raca_gado (table: lote_gado)


ALTER TABLE lote_gado ADD CONSTRAINT lote_gado_raca_gado 
    FOREIGN KEY (raca_gado_id)
    REFERENCES raca_gado (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  movimentacao_gado_lote_gado (table: movimentacao_gado)


ALTER TABLE movimentacao_gado ADD CONSTRAINT movimentacao_gado_lote_gado 
    FOREIGN KEY (lote_gado_id)
    REFERENCES lote_gado (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  movimentacao_gado_tipo_movimentacao (table: movimentacao_gado)


ALTER TABLE movimentacao_gado ADD CONSTRAINT movimentacao_gado_tipo_movimentacao 
    FOREIGN KEY (tipo_movimentacao_id)
    REFERENCES tipo_movimentacao (id)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;






-- End of file.

