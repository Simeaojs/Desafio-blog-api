package com.blog.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "/tb_comentario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;


    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeCriacao;

    @JoinColumn(unique = true, name = "idUsuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(nullable = false, name = "idPost")
    @ManyToOne
    private Post post;

}
