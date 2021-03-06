CREATE SEQUENCE TBUSUARIO_CLIENTE_SEQ
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
CREATE TABLE TBUSUARIO_CLIENTE(
    CODIGO  BIGINT NOT NULL DEFAULT NEXTVAL('TBUSUARIO_CLIENTE_SEQ'),
   
   	CODIGO_CLIENTE BIGINT NOT NULL,
   	CODIGO_USUARIO BIGINT NOT NULL
   
    
    
);
ALTER TABLE TBUSUARIO_CLIENTE ADD CONSTRAINT PK_TBUSUARIO_CLIENTE PRIMARY KEY (CODIGO);



ALTER TABLE TBUSUARIO_CLIENTE ADD CONSTRAINT FK_TBUSUARIO_CLIENTE_CLI FOREIGN KEY (CODIGO_USUARIO) REFERENCES TBUSUARIO(CODIGO);
ALTER TABLE TBUSUARIO_CLIENTE ADD CONSTRAINT FK_TBUSUARIO_CLIENTE_US FOREIGN KEY (CODIGO_CLIENTE) REFERENCES TBCLIENTE(CODIGO);

INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (1, 'Gasolina Comum', 'GASOLINA', 'R$ / litro', CURRENT_DATE , true);
INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (2, 'Gasolina Aditivada', 'GASOLINA', 'R$ / litro', CURRENT_DATE , true);
INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (3, 'Gasolina Premium', 'GASOLINA', 'R$ / litro', CURRENT_DATE , true);
INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (4, 'Etanol Hidratado', 'ETANOL', 'R$ / litro', CURRENT_DATE , true);
INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (5, 'Diesel S 10', 'DIESEL', 'R$ / litro', CURRENT_DATE , true);
INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (6, 'Diesel S 500', 'DIESEL', 'R$ / litro', CURRENT_DATE , true);
INSERT INTO TBPRODUTO  (codigo, descricao, TIPO, unidade, INCLUSAO, ativo ) VALUES (7, 'GNV ', 'GAS', 'R$ / m³', CURRENT_DATE , true);
