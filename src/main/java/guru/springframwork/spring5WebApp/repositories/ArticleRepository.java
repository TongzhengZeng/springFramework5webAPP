package guru.springframwork.spring5WebApp.repositories;

import guru.springframwork.spring5WebApp.domain.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
