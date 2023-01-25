package studio.moonid.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import studio.moonid.demo.dto.CommentDto;
import studio.moonid.demo.service.CommentService;

import java.util.List;

@RestController
public class CommentApiController  {
    @Autowired
    private CommentService commentService;

    // api pattern
    // http://localhost:8080/api/articles/4/comments

    // search
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> commments(@PathVariable Long articleId) {
        // forward to service
        List<CommentDto> dtos = commentService.comments(articleId);

        // return
        return dtos != null ?
        ResponseEntity.status(HttpStatus.OK).body(dtos):
        ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // create

    // modify

    // delete

}
