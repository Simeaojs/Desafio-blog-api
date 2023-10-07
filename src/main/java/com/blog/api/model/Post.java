package com.blog.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "O nome do post deve ser informado")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de criação deve ser informada")
    private LocalDate dataDeCriacao;

    @JoinColumn(name = "IdUsuario")
    @OneToOne
    private Usuario usuario;

}
