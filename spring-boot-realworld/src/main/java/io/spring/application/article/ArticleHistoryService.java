package io.spring.application.article;

import io.spring.core.article.Article;
import io.spring.domain.article.ArticleHistory;
import io.spring.domain.article.ArticleHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticleHistoryService {
    private final ArticleHistoryRepository articleHistoryRepository;
    public void save(Article article, String mode) {
        System.out.println(">>> save history!!! ");

        ArticleHistory articleHistory = new ArticleHistory();
        articleHistory.setArticleId(article.getId());
        articleHistory.setSlug(article.getSlug());
        articleHistory.setBody(article.getBody());
        articleHistory.setTitle(article.getTitle());
        articleHistory.setDescription(article.getDescription());
        //articleHistory.setCreatedAt(article.getCreatedAt());
        //articleHistory.setUpdatedAt(article.getUpdatedAt());
        articleHistory.setUserId(article.getUserId());
        articleHistory.setMode(mode);

        articleHistoryRepository.save(articleHistory);
    }
}
