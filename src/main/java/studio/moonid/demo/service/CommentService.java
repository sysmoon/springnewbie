package studio.moonid.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.moonid.demo.dto.CommentDto;
import studio.moonid.demo.entity.Comment;
import studio.moonid.demo.repository.ArticleRepository;
import studio.moonid.demo.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDto> comments(Long articleId) {
        // search comment
        List<Comment> commments = commentRepository.findByArticleId(articleId);

        // transform (endtity -> dto)
        List<CommentDto> dtos = new ArrayList<CommentDto>();

        for (int i=0; i < commments.size(); i++){

        }

        // return
        return null;
    }
}
