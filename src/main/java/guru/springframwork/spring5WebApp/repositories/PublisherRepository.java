package guru.springframwork.spring5WebApp.repositories;

import guru.springframwork.spring5WebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
