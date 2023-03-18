package agard.spring.spring6demo.repositories;

import agard.spring.spring6demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
