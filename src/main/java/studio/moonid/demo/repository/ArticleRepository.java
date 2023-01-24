package studio.moonid.demo.repository;

import org.springframework.stereotype.Repository;
import studio.moonid.demo.dto.ArticleForm;
import studio.moonid.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();

}