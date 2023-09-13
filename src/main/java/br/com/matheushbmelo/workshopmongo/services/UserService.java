package br.com.matheushbmelo.workshopmongo.services;

import br.com.matheushbmelo.workshopmongo.domain.User;
import br.com.matheushbmelo.workshopmongo.repositories.UserRepository;
import br.com.matheushbmelo.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Nenhum objeto foi encontrado com o ID:" + id));
    }

    public void insertUser(User obj){
        userRepository.save(obj);
    }

    public void deleteUser(String id){
        findUserById(id);
        userRepository.deleteById(id);
    }

    public void updateUser(User obj){
        User userPersistido = findUserById(obj.getId());
        BeanUtils.copyProperties(obj, userPersistido);
        userRepository.save(userPersistido);
    }
}
