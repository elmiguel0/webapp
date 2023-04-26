package webapp.services;

import org.springframework.stereotype.Service;

import webapp.domain.Author;
import webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
    
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll(){
        return authorRepository.findAll();
    }
}
