package br.com.matheushbmelo.workshopmongo.config;

import br.com.matheushbmelo.workshopmongo.domain.Post;
import br.com.matheushbmelo.workshopmongo.domain.User;
import br.com.matheushbmelo.workshopmongo.domain.dto.AuthorDto;
import br.com.matheushbmelo.workshopmongo.repositories.PostRepository;
import br.com.matheushbmelo.workshopmongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Eduarda", "eduarda@email.com");
        User u2 = new User(null, "Maria Luiza", "luiza@email.com");
        User u3 = new User(null, "Leticia Vitoria", "leticia@email.com");
        User u4 = new User(null, "Matheus Henrique", "matheus@email.com");
        User u5 = new User(null, "Davi Jose", "davi@email.com");
        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

        Post p1 = new Post(null, LocalDateTime.parse("21/07/2001 15:45:30", dtf), "Viagem para Recife", "Embarcando para a cidade de Recife", new AuthorDto(u4));
        Post p2 = new Post(null, LocalDateTime.parse("18/03/2008 09:22:00", dtf), "Indo a escola", "Aula de quimica em breve!", new AuthorDto(u5));
        postRepository.saveAll(Arrays.asList(p1, p2));
    }
}
