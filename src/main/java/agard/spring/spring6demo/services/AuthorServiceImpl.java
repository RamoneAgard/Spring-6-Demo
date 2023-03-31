package agard.spring.spring6demo.services;

import agard.spring.spring6demo.domain.Author;
import agard.spring.spring6demo.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    //Fields //
    private final AuthorRepository authorRepository;

    // Constructors //
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Public Methods //
    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
