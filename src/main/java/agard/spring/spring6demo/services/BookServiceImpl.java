package agard.spring.spring6demo.services;

import agard.spring.spring6demo.domain.Book;
import agard.spring.spring6demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    // Fields //
    private final BookRepository bookRepository;

    // Constructors //
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Public Methods //
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
