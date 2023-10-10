package com.blog.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Usuario")
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome do usuario deve ser informado")
    private String nome;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "O sobrenome do usuario deve ser informado")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O email do usuario deve ser informado")
    @Email(message = "O email informado não é válido")
    private String email;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "A senha do usuario deve ser informada")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "A senha deve conter no mínimo 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    private String senha;

}
