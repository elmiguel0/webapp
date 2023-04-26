package webapp.services;

import org.springframework.stereotype.Service;

import webapp.domain.Publisher;
import webapp.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }
    
}
