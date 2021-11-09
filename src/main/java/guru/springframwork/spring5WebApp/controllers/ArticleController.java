package guru.springframwork.spring5WebApp.controllers;

import guru.springframwork.spring5WebApp.repositories.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping("/articles")
    public String getArticles(Model model){
        model.addAttribute("articles", articleRepository.findAll());

        return "articles";
    }
}
