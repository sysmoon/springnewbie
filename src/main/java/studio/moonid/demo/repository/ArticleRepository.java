package studio.moonid.demo.repository;

import org.springframework.stereotype.Repository;
import studio.moonid.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}