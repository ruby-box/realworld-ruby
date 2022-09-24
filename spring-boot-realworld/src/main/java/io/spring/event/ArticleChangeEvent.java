package io.spring.event;

import io.spring.core.article.Article;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ArticleChangeEvent extends ApplicationEvent {
    private String mode;
    public ArticleChangeEvent(Article article, String mode) {
        super(article);
        this.mode = mode;
    }
}
