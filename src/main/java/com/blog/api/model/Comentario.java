package com.blog.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "O nome do post deve ser informado")
    private String texto;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de criação deve ser informada")
    private LocalDate dataDeCriacao;

    @JoinColumn(name = "idUsuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "idPost")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

}
