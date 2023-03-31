package agard.spring.spring6demo.services;

import agard.spring.spring6demo.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
