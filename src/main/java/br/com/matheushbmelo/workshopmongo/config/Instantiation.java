package br.com.matheushbmelo.workshopmongo.config;

import br.com.matheushbmelo.workshopmongo.domain.User;
import br.com.matheushbmelo.workshopmongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;

    public Instantiation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Eduarda", "eduarda@email.com");
        User u2 = new User(null, "Maria Luiza", "luiza@email.com");
        User u3 = new User(null, "Leticia Vitoria", "leticia@email.com");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
