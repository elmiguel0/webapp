package webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import webapp.domain.Author;
import webapp.domain.Book;
import webapp.domain.Publisher;
import webapp.repositories.AuthorRepository;
import webapp.repositories.BookRepository;
import webapp.repositories.PublisherRepository;

@Component
public class Bootstrap implements CommandLineRunner{
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
        PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        Publisher penguinPublisher = new Publisher();
        penguinPublisher.setName("Pinguin Random House");
        penguinPublisher.setAddress("10807 New Allegiance Drive, Suite 500");
        penguinPublisher.setCity("Colorado Springs");
        penguinPublisher.setState("CO");
        penguinPublisher.setZip("80921");

        Publisher harpePublisher = new Publisher();
        harpePublisher.setName("HarperCollins");
        harpePublisher.setAddress("");
        harpePublisher.setState("California");
        harpePublisher.setCity("Richmond");
        harpePublisher.setZip("44820");

        publisherRepository.save(penguinPublisher);
        publisherRepository.save(harpePublisher);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }

    
}
