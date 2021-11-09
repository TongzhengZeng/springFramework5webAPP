package guru.springframwork.spring5WebApp.bootstrap;

import guru.springframwork.spring5WebApp.domain.Article;
import guru.springframwork.spring5WebApp.domain.Author;
import guru.springframwork.spring5WebApp.domain.Publisher;
import guru.springframwork.spring5WebApp.repositories.ArticleRepository;
import guru.springframwork.spring5WebApp.repositories.AuthorRepository;
import guru.springframwork.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, ArticleRepository articleRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);
        System.out.println("Publisher count: "+ publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Article ddd = new Article("Domain Driven Design","123123");
        eric.getArticles().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getArticles().add(ddd);
        authorRepository.save(eric);
        articleRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Article noEJB = new Article("J2EE Development withou EJB", "39394599");
        rod.getArticles().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getArticles().add(noEJB);
        authorRepository.save(rod);
        articleRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Articles: " + articleRepository.count());
        System.out.println("Publisher number of articles: " + publisher.getArticles().size());
    }
}
