CREATE TABLE IF NOT EXISTS tb_comentarios (
    idComentario BIGINT AUTO_INCREMENT PRIMARY KEY,
    texto TEXT,
    dataDeCriacao DATE NOT NULL,
    idUsuario BIGINT,
    idPost BIGINT,
    FOREIGN KEY (idUsuario) REFERENCES tb_usuarios (idUsuario),
    FOREIGN KEY (idPost) REFERENCES tb_posts (idPost) ON DELETE CASCADE
);
