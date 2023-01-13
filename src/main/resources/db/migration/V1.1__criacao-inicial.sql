/* LIMPANDO */

alter table
    if exists cidade drop constraint if exists FK_estado__cidade;

alter table
    if exists grupo_permissao drop constraint if exists FK_permissao__grupo_permisao;

alter table
    if exists grupo_permissao drop constraint if exists FK_grupo__grupo_permisao;

alter table
    if exists produto drop constraint if exists FK_restaurante__produto;

alter table
    if exists restaurante drop constraint if exists FK_cozinha__restaurante;

alter table
    if exists restaurante drop constraint if exists FK_cidade__restaurante;

alter table
    if exists restaurante_forma_pagamento drop constraint if exists FK_forma_pagamento__restaurante_forma_pagamento;

alter table
    if exists restaurante_forma_pagamento drop constraint if exists FK_restaurante__restaurante_forma_pagamento;

alter table
    if exists usuario_grupo drop constraint if exists FK_grupo__usuario_grupo;

alter table
    if exists usuario_grupo drop constraint if exists FK_usuario__usuario_grupo;

drop table if exists cidade cascade;

drop table if exists cozinha cascade;

drop table if exists estado cascade;

drop table if exists forma_pagamento cascade;

drop table if exists grupo cascade;

drop table if exists grupo_permissao cascade;

drop table if exists permissao cascade;

drop table if exists produto cascade;

drop table if exists restaurante cascade;

drop table if exists restaurante_forma_pagamento cascade;

drop table if exists usuario cascade;

drop table if exists usuario_grupo cascade;

/* CRIANDO TABELAS */

create table cidade (
    id bigserial not null,
    nome varchar(60) not null,
    estado_id bigint not null,
    primary key (id)
);

create table cozinha (
    id bigserial not null,
    nome varchar(60) not null,
    primary key (id)
);

create table estado (
    id bigserial not null,
    nome varchar(60) not null,
    primary key (id)
);

create table forma_pagamento (
    id bigserial not null,
    descricao varchar(255) not null,
    primary key (id)
);

create table grupo (
    id bigserial not null,
    nome varchar(60) not null,
    primary key (id)
);

create table grupo_permissao (
    grupo_id bigint not null,
    permissao_id bigint not null
);

create table permissao (
    id bigserial not null,
    descricao varchar(255) not null,
    nome varchar(60) not null,
    primary key (id)
);

create table produto (
    id bigserial not null,
    ativo boolean not null,
    descricao varchar(255) not null,
    nome varchar(60) not null,
    preco numeric(38, 2) not null,
    restaurante_id bigint not null,
    primary key (id)
);

create table restaurante (
    id bigserial not null,
    data_atualizacao timestamp(0) not null,
    data_cadastro timestamp(0) not null,
    endereco_bairro varchar(50),
    endereco_cep varchar(10),
    endereco_logradouro varchar(50),
    endereco_numero varchar(20),
    nome varchar(255) not null,
    taxa_frete numeric(38, 2) not null,
    cozinha_id bigint not null,
    endereco_cidade_id bigint,
    primary key (id)
);

create table restaurante_forma_pagamento (
    restaurante_id bigint not null,
    forma_pagamento_id bigint not null
);

create table usuario (
    id bigserial not null,
    data_cadastro timestamp(0) not null,
    email varchar(100) not null,
    nome varchar(60) not null,
    senha varchar(255) not null,
    primary key (id)
);

create table usuario_grupo (
    usuario_id bigint not null,
    grupo_id bigint not null
);

alter table
    if exists cidade
add
    constraint FK_estado__cidade foreign key (estado_id) references estado;

alter table
    if exists grupo_permissao
add
    constraint FK_permissao__grupo_permisao foreign key (permissao_id) references permissao;

alter table
    if exists grupo_permissao
add
    constraint FK_grupo__grupo_permisao foreign key (grupo_id) references grupo;

alter table
    if exists produto
add
    constraint FK_restaurante__produto foreign key (restaurante_id) references restaurante;

alter table
    if exists restaurante
add
    constraint FK_cozinha__restaurante foreign key (cozinha_id) references cozinha;

alter table
    if exists restaurante
add
    constraint FK_cidade__restaurante foreign key (endereco_cidade_id) references cidade;

alter table
    if exists restaurante_forma_pagamento
add
    constraint FK_forma_pagamento__restaurante_forma_pagamento foreign key (forma_pagamento_id) references forma_pagamento;

alter table
    if exists restaurante_forma_pagamento
add
    constraint FK_restaurante__restaurante_forma_pagamento foreign key (restaurante_id) references restaurante;

alter table
    if exists usuario_grupo
add
    constraint FK_grupo__usuario_grupo foreign key (grupo_id) references grupo;

alter table
    if exists usuario_grupo
add
    constraint FK_usuario__usuario_grupo foreign key (usuario_id) references usuario;