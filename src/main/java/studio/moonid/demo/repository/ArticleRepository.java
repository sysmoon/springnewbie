package studio.moonid.demo.repository;

import studio.moonid.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    
}