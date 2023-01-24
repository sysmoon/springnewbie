package studio.moonid.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import studio.moonid.demo.dto.ArticleForm;
import studio.moonid.demo.entity.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // expected
        Article a = new Article(1L, "WFA2.1","11111");
        Article b = new Article(2L, "WFA2.2","22222");
        Article c = new Article(3L, "WFA2.3","33333");
        Article d = new Article(4L, "What is your favorite movie?","tell me. blabla");
        Article e = new Article(5L, "What is your favorite food?","tell me. blabla");
        Article f = new Article(6L, "What is your favorite hobby?","tell me. blabla");

        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c, d, e, f));

        // actual
        List<Article> articles =  articleService.index();

        // compare
        assertEquals(expected.toString(), articles.toString());

    }

    @Test
    void show_success__존재하는_id_입력() {
        // expected
        Long id = 1L;
        Article expected = new Article(id, "WFA2.1", "11111");

        // actual
        Article article = articleService.show(id);

        // assert
        assertEquals(expected.toString(), article.toString());

        // compare partial (id, titile, content)
        String expectedContent = expected.getContent();
        String actualContent = article.getContent();
        assertEquals(expectedContent, actualContent);

    }

    @Test
    void show_fail__존재하지_않는_id_입력() {
        // expected
        Long id = -1L;
        Article expected = null;

        // actual
        Article article = articleService.show(id);

        // compare
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_success_title과_conten만_있는_dto_입력() {
        // expected
        String title = "7777";
        String content = "gggg";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(7L, title, content);

        // actual
        Article article = articleService.create(dto);

        // compare
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_fail_id가_포함된_dto_입력() {
        // expected
        String title = "4444";
        String content = "dddd";
        ArticleForm dto = new ArticleForm(7L, title, content);
        Article expected = null;

        // actual
        Article article = articleService.create(dto);

        // compare
        assertEquals(expected, article);
    }

}