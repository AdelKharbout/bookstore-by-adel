package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DatenBank {

    private static Map<String, Authors> authorMap = new HashMap<>();

    public static String errorMessage = "The author you requested doesn't exist. Please review your parameters!";

    private static Object errorChecking(String authorId) {
        if(authorMap.get(authorId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
    }

    public static Authors postAuthors(Authors author) {
        String authorId = UUID.randomUUID().toString();
        author.setId(authorId);
        authorMap.put(authorId, author);
        return author;
    }

    public static Authors getAuthors(String authorId) {
        errorChecking(authorId);
        Authors getAuthor = authorMap.get(authorId);
        return getAuthor;
    }

    public static void deleteAuthors(String authorId) {
        errorChecking(authorId);
        authorMap.remove(authorId);
    }

    public static Authors putAuthors(String authorId, Authors authorFromUser) {
        errorChecking(authorId);
        authorFromUser.setId(authorId);
        authorMap.replace(authorId, authorFromUser);
        return authorFromUser;
    }
}
