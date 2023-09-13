package br.com.matheushbmelo.workshopmongo.controllers;

import br.com.matheushbmelo.workshopmongo.domain.User;
import br.com.matheushbmelo.workshopmongo.domain.dto.UserDto;
import br.com.matheushbmelo.workshopmongo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users = userService.findAllUsers();
        List<UserDto> usersDtos = users.stream().map(UserDto::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(usersDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable(value = "id") String id){
        User user = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserDto(user));
    }

    @PostMapping("")
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto, HttpServletRequest request){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.insertUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String id, @RequestBody UserDto userDto){
        User user = User.fromDto(userDto);
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }
}
