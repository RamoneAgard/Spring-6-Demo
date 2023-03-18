package agard.spring.spring6demo.repositories;

import agard.spring.spring6demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

