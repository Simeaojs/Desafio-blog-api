CREATE TABLE
    IF NOT EXISTS tb_posts (
        idPost BIGINT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        conteudo TEXT,
        dataDeCriacao DATE NOT NULL,
        IdUsuario BIGINT,
        FOREIGN KEY (IdUsuario) REFERENCES tb_usuarios (idUsuario)
    );