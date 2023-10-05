CREATE TABLE IF NOT EXISTS tb_post (
    idPost BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    conteudo TEXT ,
    dataDeCriacao DATE NOT NULL,
    idUsuario BIGINT UNIQUE,
    PRIMARY KEY(idPost),

    FOREIGN KEY (idUsuario) REFERENCES tb_Usuarios(idUsuario)
);