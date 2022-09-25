package io.spring.api;

import io.spring.api.exception.ResourceNotFoundException;
import io.spring.application.Page;
import io.spring.application.article.ArticleHistoryService;
import io.spring.application.data.ArticleData;
import io.spring.core.user.User;
import io.spring.domain.article.ArticleHistory;
import io.spring.domain.article.ArticleHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/article-history")
@AllArgsConstructor
public class ArticleHistoryApi {
    private final ArticleHistoryService articleHistoryService;
    private final ArticleHistoryRepository articleHistoryRepository;

    @GetMapping
    public ResponseEntity<?> historyList(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", defaultValue = "20") int limit,
                                     @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(
                articleHistoryService.findArticleHistory(new Page(offset, limit), user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> articleHistory(
            @PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        return articleHistoryRepository
                .findById(id)
                .map(articleData -> ResponseEntity.ok(articleHistoryResponse(articleData)))
                .orElseThrow(ResourceNotFoundException::new);
    }

    private Map<String, Object> articleHistoryResponse(ArticleHistory articleData) {
        return new HashMap<String, Object>() {
            {
                put("article_history", articleData);
            }
        };
    }
}
