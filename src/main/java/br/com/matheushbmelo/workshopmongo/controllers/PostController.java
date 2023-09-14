package br.com.matheushbmelo.workshopmongo.controllers;

import br.com.matheushbmelo.workshopmongo.domain.Post;
import br.com.matheushbmelo.workshopmongo.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable(value = "id") String id) {
        Post post = postService.findPostById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
}
