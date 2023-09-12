package br.com.matheushbmelo.workshopmongo.controllers;

import br.com.matheushbmelo.workshopmongo.domain.User;
import br.com.matheushbmelo.workshopmongo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
