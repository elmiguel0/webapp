package webapp.services;

import webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
