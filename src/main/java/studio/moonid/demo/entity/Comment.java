package studio.moonid.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // many comment related one article.
    @JoinColumn(name = "article_id") // article_id = FK
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;
}