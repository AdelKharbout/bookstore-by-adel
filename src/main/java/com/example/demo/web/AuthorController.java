package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@ResponseBody
@RequestMapping(value = {"/api/author"})
class AuthorController {

    private Map<String, Author> authorMap = new HashMap<>();

    public String errorMessage = "The author you requested doesn't exist. Please review your parameters!";

    private Object errorChecking(String authorId) {
        if(authorMap.get(authorId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, this.errorMessage);
        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, this.errorMessage);
    }

    @PostMapping(consumes = {"application/json"},
            produces = {"application/json"})
    Author addAuthor(@RequestBody Author author) {
        String authorId = UUID.randomUUID().toString();
        author.setId(authorId);
        authorMap.put(authorId, author);
        return author;
    }

    @ResponseBody
    @GetMapping(value = {"/{authorId}"},
            produces = {"application/json"})
    Author author(@PathVariable String authorId){
        errorChecking(authorId);
        Author getAuthor = authorMap.get(authorId);
        return getAuthor;
    }

    @ResponseBody
    @DeleteMapping(value = {"/{authorId}"},
            consumes = {"application/json"})
    void removeAuthor(@PathVariable String authorId){
        errorChecking(authorId);
        authorMap.remove(authorId);
    }

    @ResponseBody
    @PutMapping(value = {"/{authorId}"},
            consumes = {"application/json"},
            produces = {"application/json"})
    Author updateAuthor(@PathVariable String authorId, @RequestBody Author authorFromUser){
        errorChecking(authorId);
        authorFromUser.setId(authorId);
        authorMap.replace(authorId, authorFromUser);
        return authorFromUser;
    }
}