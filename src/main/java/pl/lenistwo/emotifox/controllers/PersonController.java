package pl.lenistwo.emotifox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lenistwo.emotifox.documents.Person;
import pl.lenistwo.emotifox.exceptions.PersonNotFoundException;
import pl.lenistwo.emotifox.repositories.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin("*")
@RestController
@RequestMapping("/actor")
public class PersonController {

    private final PersonRepository repo;

    @Autowired
    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public Flux<Person> getActors() {
        return Flux.fromIterable(repo.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Person> getActor(@PathVariable String id) {
        return Mono.just(repo.findById(id).orElseThrow(PersonNotFoundException::new));
    }

    @PostMapping
    public void saveActor(Person person){
        repo.save(person);
    }
}
