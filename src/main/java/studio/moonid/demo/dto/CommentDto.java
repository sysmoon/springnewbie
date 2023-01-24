package studio.moonid.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class CommentDto {
    private Long id;
    private Long articleId;
    private String nickname;
    private String body;
}
