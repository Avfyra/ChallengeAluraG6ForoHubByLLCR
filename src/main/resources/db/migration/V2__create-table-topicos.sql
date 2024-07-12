create table topicos(

 id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(400) not null unique,
    fecha varchar(100) not null,
    estatus varchar(100) not null,
    autor_id bigint not null,  -- Cambia el nombre de la columna a autor_id
    curso varchar(100) not null,
    activo BOOLEAN NOT NULL DEFAULT TRUE,

    primary key (id),
    foreign key (autor_id) references usuarios(id)  -- Agrega la clave foránea
);
