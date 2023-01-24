package studio.moonid.demo.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import studio.moonid.demo.entity.Article;
import studio.moonid.demo.entity.Comment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("Search all comment related certain article")
    void findByArticleId() {
        // case1. 4번 게시물의 모든 댓글 조회
        {
            // input
            Long articleId = 4L;

            // run
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // expect
            Article article = new Article(4L, "What is your favorite movie?", "tell me. blabla");
            Comment a = new Comment(1L, article, "boris", "matrix");
            Comment b = new Comment(2L, article, "joon", "good will hunting");
            Comment c = new Comment(3L, article, "jay", "surinam");

            List<Comment> expected = Arrays.asList(a, b, c);

            // validation
            assertEquals(expected.toString(), comments.toString(), "print all comment of article 4");
        }

        // case2. 1번 게시물의 모든 댓글 조회
        {
            // input
            Long articleId = 1L;

            // run
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // expected
            Article article = new Article(1L, "WFA2.1", "tell me. blabla");
            List <Comment> expected = Arrays.asList();

            // validation
            assertEquals(expected.toString(), comments.toString(), "article 1 has no comment");
        }
    }


    @Test
    @DisplayName("Search all comment related certain nickname.")
    void findByNickname() {
    /* Case1. Search all comment writtem by nickname(daniel) */
        {
            // input
            String nickname = "daniel";

            // run
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // expect
            Comment a = new Comment(4L, new Article(5L, "What is your favorite food?", "tell me. blabla"), "daniel", "sushi");
            Comment b = new Comment(7L, new Article(6L, "What is your favorite hobby?", "tell me. blabla"), "daniel", "tennis");
            List<Comment> expected = Arrays.asList(a, b);

            // validation
            assertEquals(expected.toString(), comments.toString(), "Print out all comment of nickname(daniel)");
        }
    }
}