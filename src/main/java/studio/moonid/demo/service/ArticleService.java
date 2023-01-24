package studio.moonid.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.function.EntityResponse;
import org.xml.sax.EntityResolver;
import studio.moonid.demo.dto.ArticleForm;
import studio.moonid.demo.entity.Article;
import studio.moonid.demo.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        if(article.getId() != null) {
            log.info("Bad request, id can't be input. article:" + article.toString());
            return null;
        }

        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // dto -> entity
        Article article = dto.toEntity();

        // find target
        Article target = articleRepository.findById(article.getId()).orElse(null);

        // exception
        if(target == null || id != target.getId()) {
            log.info("Invalid request! id: {} , article: {}", id, article.toString());
            return null;
        }

        // update
        target.patch(article);
        Article updated = articleRepository.save(target);

        // return
        return updated;
    }

    public Article delete(Long id) {
        // find target
        Article target = articleRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }

        // delete target
        articleRepository.delete(target);

        // return deleted
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // dtos -> entity
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        // save entity to DB
        articleList.stream()
                .forEach(article -> articleRepository.save(article));

        // exception
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("payment failed.")
        );

        // return
        return articleList;
    }
}
