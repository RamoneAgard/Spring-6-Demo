package agard.spring.spring6demo.services;

import agard.spring.spring6demo.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
