package com.blog.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "/comentario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeCriacao;

    @JoinColumn(name = "idUsuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "idPost")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

}
