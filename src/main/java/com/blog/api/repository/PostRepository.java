package com.blog.api.repository;

import com.blog.api.model.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUsuarioIdUsuario(Long id);
}
