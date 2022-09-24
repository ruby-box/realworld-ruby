package io.spring.domain.article;

import io.spring.core.article.Tag;
import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

@Table(name = "article_history")
@Entity
@Data
public class ArticleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String userId;
    @Column(columnDefinition = "varchar(255)")
    private String articleId;
    @Column(columnDefinition = "varchar(255)")
    private String slug;
    @Column(columnDefinition = "varchar(255)")
    private String title;
    @Lob
    private String description;
    @Lob
    private String body;
    @Column(columnDefinition = "char(1)")
    private String mode;
    //@OneToMany
    //private List<Tag> tags;

    //@Column(columnDefinition = "timestamp")
    @CreatedDate
    private LocalDateTime createdAt;
}
