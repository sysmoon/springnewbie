package studio.moonid.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import studio.moonid.demo.dto.ArticleForm;
import studio.moonid.demo.entity.Article;
import studio.moonid.demo.repository.ArticleRepository;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());

        // 1. dto 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. repository 에게 entity 를 DB 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}