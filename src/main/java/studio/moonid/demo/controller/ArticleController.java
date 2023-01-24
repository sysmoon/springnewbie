package studio.moonid.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import studio.moonid.demo.dto.ArticleForm;
import studio.moonid.demo.entity.Article;
import studio.moonid.demo.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

        // 1. dto -> entity 변환
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. repository 에게 entity 를 DB 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id:" + id);

        // 1. id로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 articles 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        // method1. casting
        // List<Article> articleEntityList = (List<Article>)articleRepository.findAll();

        // method2. define Iterable<Article>
        // Iterable<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 articles 을 view 전달
        model.addAttribute("articleList", articleEntityList);

        // 3. view 페이지 설정
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // 뷰 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());

        // 1. dto to entity
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2. save entity to db
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        if(target != null) {
            articleRepository.save(articleEntity);
        }

        //3. redirect to result of modified page.
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("get delete request:" + id);

        // 1. get entity from db
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        // 2. delete db
        if(target != null) {
            articleRepository.delete(target);
        }

        // 3. redirect
        return "redirect:/articles";
    }
}