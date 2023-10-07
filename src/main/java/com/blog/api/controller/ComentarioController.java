package com.blog.api.controller;

import com.blog.api.model.Comentario;
import com.blog.api.model.Post;
import com.blog.api.repository.ComentarioRepository;
import com.blog.api.repository.PostRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PostRepository postRepository;


    @PostMapping("/posts/{Id}/comentarios")
    public ResponseEntity<Comentario> cadastrarComentario(@PathVariable("Id") @Valid Long Id,
            @Valid @RequestBody Comentario comentario) {
        Optional<Post> postExistente = postRepository.findById(Id);

        if (postExistente.isPresent()) {
            comentario.setPost(postExistente.get());
            Comentario novoComentario = comentarioRepository.save(comentario);

            return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/posts/{id}")
    public List<Comentario> listarComentariosDeUmPost(@PathVariable("id") Long id) {
        return comentarioRepository.findByPostIdPost(id);
    }

    @GetMapping("/posts")
    public List<Comentario> listarComentariosDeTodosOsPosts() {
        return comentarioRepository.findAll();
    }

    @PutMapping("/{id}")
    public Comentario atualizarComentario(@PathVariable("id") Long id, @Valid @RequestBody Comentario comentario) {
        Optional<Comentario> comentarioExistente = comentarioRepository.findById(id);

        if (comentarioExistente.isPresent()) {
            comentarioExistente.get().setTexto(comentario.getTexto());

            return comentarioRepository.save(comentarioExistente.get());

        }

        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarComentario(@PathVariable("id") Long id) {
        Optional<Comentario> comentario = comentarioRepository.findById(id);

        if (comentario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        comentarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
