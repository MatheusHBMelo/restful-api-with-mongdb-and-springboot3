package br.com.matheushbmelo.workshopmongo.repositories;

import br.com.matheushbmelo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
