package agard.spring.spring6demo.repositories;

import agard.spring.spring6demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
