package studio.moonid.demo.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import studio.moonid.demo.entity.Article;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
