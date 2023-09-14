package br.com.matheushbmelo.workshopmongo.services;

import br.com.matheushbmelo.workshopmongo.domain.Post;
import br.com.matheushbmelo.workshopmongo.repositories.PostRepository;
import br.com.matheushbmelo.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post findPostById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Nenhum objeto foi encontrado com o ID:" + id));
    }
}
