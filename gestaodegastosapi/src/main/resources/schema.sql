create table TBL_CATEGORIA
(
   id integer not null,
   descricao varchar(100) not null,
   primary key(id),
   constraint CONST_TBL_CATEGORIA unique (id, descricao)
);

CREATE SEQUENCE SEQ_CATEGORIA START WITH 0 MINVALUE 0 MAXVALUE 9223372036854775807 NOCYCLE;