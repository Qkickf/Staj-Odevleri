package com.furkant.jugtours.web;

import com.furkant.jugtours.model.Actor;
import com.furkant.jugtours.model.FilmRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmController {
    private final Logger log = LoggerFactory.getLogger(FilmController.class);
    private final FilmRepository filmRepository;
    private FilmRepository FilmRepository;

    public FilmController(FilmRepository groupRepository) {
        this.filmRepository = groupRepository;
    }

    @GetMapping("/cinemas")
    Collection<Actor> groups() {
        return filmRepository.findAll();
    }

    @GetMapping("/cinema/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Actor> group = filmRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cinema")
    ResponseEntity<Actor> createGroup(@Valid @RequestBody Actor group) throws URISyntaxException {
        log.info("Request to create film: {}", group);
        Actor result = filmRepository.save(group);
        return ResponseEntity.created(new URI("/api/film/" + result.getId()))
                .body(result);
    }

    @PutMapping("/cinema/{id}")
    ResponseEntity<Actor> updateGroup(@Valid @RequestBody Actor group) {
        log.info("Request to update film: {}", group);
        Actor result = filmRepository.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/cinema/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        filmRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
