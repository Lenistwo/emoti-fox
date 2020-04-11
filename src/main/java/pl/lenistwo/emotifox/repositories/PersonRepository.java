package pl.lenistwo.emotifox.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lenistwo.emotifox.documents.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}