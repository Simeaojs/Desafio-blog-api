package com.blog.api.controller;

import com.blog.api.model.Post;
import com.blog.api.repository.PostRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Post> cadastrarPost(@RequestBody @Valid Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));

    }

    @GetMapping
    public ResponseEntity<Page<Post>> listarPost(@PageableDefault(size = 10) Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> listarPorId(@PathVariable("id") Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(post.get());

    }

    @PutMapping("/{id}")
    public Post atualizarPorId(@PathVariable("id") Long id, @RequestBody @Valid Post post) {
        Optional<Post> postExistente = postRepository.findById(id);

        if (postExistente.isPresent()) {
            postExistente.get().setConteudo(post.getConteudo());
            postExistente.get().setTitulo(post.getTitulo());
            postExistente.get().setDataDeCriacao(post.getDataDeCriacao());
            postExistente.get().setUsuario(post.getUsuario());

            return postRepository.save(postExistente.get());

        }

        return null;

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarPost(@PathVariable("id") Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        postRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
