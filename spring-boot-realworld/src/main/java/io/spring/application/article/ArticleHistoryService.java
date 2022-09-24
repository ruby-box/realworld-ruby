package io.spring.application.article;

import io.spring.BeanUtils;
import io.spring.core.article.Article;
import io.spring.domain.article.ArticleHistory;
import io.spring.domain.article.ArticleHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleHistoryService {
    public void save(Article article, String mode) {
        ArticleHistoryRepository articleHistoryRepository = BeanUtils.getBean(ArticleHistoryRepository.class);
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
