package io.spring.event;

import io.spring.application.article.ArticleHistoryService;
import io.spring.core.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleHistoryRequestHandler implements ApplicationListener<ArticleChangeEvent> {
    private final ArticleHistoryService articleHistoryService;

    @Override
    public void onApplicationEvent(ArticleChangeEvent event) {
        System.out.println("history save request handler!!!");
        articleHistoryService.save((Article) event.getSource(), event.getMode());
    }
}
