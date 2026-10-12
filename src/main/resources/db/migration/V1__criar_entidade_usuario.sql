create table usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome varchar(150) not null,
    email varchar(150) not null,
    senha varchar(150) not null,
    ativo boolean not null default true,
    perfil_id varchar(150) not null
);