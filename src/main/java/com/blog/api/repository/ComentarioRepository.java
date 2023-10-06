package com.blog.api.repository;

import com.blog.api.model.Comentario;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByPostIdPost(Long id);

}
