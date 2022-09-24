package io.spring.event;

import io.spring.core.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleEventPubisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void changeEntity(Article article, String mode) {
        ArticleChangeEvent event = new ArticleChangeEvent(article, mode);
        applicationEventPublisher.publishEvent(event);
    }

}
