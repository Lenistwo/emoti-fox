package pl.lenistwo.emotifox.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lenistwo.emotifox.documents.Actor;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Actor, String> {

    Optional<Actor> findById(String id);

}
