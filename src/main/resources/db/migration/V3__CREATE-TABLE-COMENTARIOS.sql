CREATE TABLE IF NOT EXISTS tb_comentario (
    idComentario BIGINT NOT NULL AUTO_INCREMENT,
    texto TEXT ,
    dataDeCriacao DATE NOT NULL,
    idUsuario BIGINT UNIQUE,
    idPost BIGINT UNIQUE,
    PRIMARY KEY(idComentario),

    FOREIGN KEY (idUsuario) REFERENCES tb_Usuarios(idUsuario),
    FOREIGN KEY (idPost) REFERENCES tb_post(idPost)
);