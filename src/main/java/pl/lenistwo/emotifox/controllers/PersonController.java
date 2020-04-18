package pl.lenistwo.emotifox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lenistwo.emotifox.documents.Actor;
import pl.lenistwo.emotifox.exceptions.ActorNotFoundException;
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

    @GetMapping("")
    public Flux<Actor> getActors() {
        return Flux.fromIterable(repo.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Actor> getActor(@PathVariable String id) {
        return Mono.just(repo.findById(id).orElseThrow(ActorNotFoundException::new));
    }

    @PostMapping
    public void saveActor(@RequestBody Actor actor) {
        repo.save(actor);
    }

    @PatchMapping
    public void updateActor(@RequestBody Actor actor) {
        System.out.println(actor);
        repo.save(actor);
    }
}
