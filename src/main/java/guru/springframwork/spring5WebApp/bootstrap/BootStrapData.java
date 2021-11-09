package guru.springframwork.spring5WebApp.bootstrap;

import guru.springframwork.spring5WebApp.domain.Article;
import guru.springframwork.spring5WebApp.domain.Author;
import guru.springframwork.spring5WebApp.repositories.ArticleRepository;
import guru.springframwork.spring5WebApp.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;

    public BootStrapData(AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Article ddd = new Article("Domain Driven Design","123123");

        eric.getArticles().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        articleRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Article noEJB = new Article("J2EE Development withou EJB", "39394599");
        rod.getArticles().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        articleRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Articles: " + articleRepository.count());

    }
}
