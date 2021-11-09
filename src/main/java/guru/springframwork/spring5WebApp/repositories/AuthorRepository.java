package guru.springframwork.spring5WebApp.repositories;

import guru.springframwork.spring5WebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
