package br.com.matheushbmelo.workshopmongo.controllers;

import br.com.matheushbmelo.workshopmongo.controllers.utils.URL;
import br.com.matheushbmelo.workshopmongo.domain.Post;
import br.com.matheushbmelo.workshopmongo.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> postsByTitle = postService.findByTitle(text);
        return ResponseEntity.status(HttpStatus.OK).body(postsByTitle);
    }
}
