package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = {"/api/authors"})
class AuthorController {

    final AuthorRepository repository;

    @Autowired
    public AuthorController(@Qualifier("authorRepositoryMapImpl") AuthorRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = {"application/json"},
            produces = {"application/json"})
    public Author addAuthor(@RequestBody Author author) {
        return repository.addAuthor(author);
    }

    @ResponseBody
    @GetMapping(produces = {"application/json"})
    public List<Author> getAllAuthors() {
        return repository.getAll();
    }

    @ResponseBody
    @GetMapping(value = {"/{authorId}"},
            produces = {"application/json"})
    public Author getAuthor(@PathVariable String authorId) {
        return repository.getAuthor(authorId);
    }

    @ResponseBody
    @DeleteMapping(value = {"/{authorId}"},
            consumes = {"application/json"})
    public void removeAuthor(@PathVariable String authorId) {
        repository.deleteAuthor(authorId);
    }

    @ResponseBody
    @PutMapping(value = {"/{authorId}"},
            consumes = {"application/json"},
            produces = {"application/json"})
    public Author updateAuthor(@PathVariable String authorId, @RequestBody Author authorFromUser) {
        return repository.updateAuthor(authorId, authorFromUser);
    }
}
