package pl.lenistwo.emotifox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lenistwo.emotifox.documents.Person;
import pl.lenistwo.emotifox.repositories.PersonRepository;
import reactor.core.publisher.Flux;

@RestController
public class MainController {

    private final PersonRepository repo;

    @Autowired
    public MainController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/actors")
    public Flux<Person> getActors() {
        return Flux.fromIterable(repo.findAll());
    }
}
