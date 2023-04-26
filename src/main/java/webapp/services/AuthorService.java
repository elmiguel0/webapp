package webapp.services;

import webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
