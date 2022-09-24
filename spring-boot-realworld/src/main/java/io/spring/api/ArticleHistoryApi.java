package io.spring.api;

import io.spring.api.exception.ResourceNotFoundException;
import io.spring.application.Page;
import io.spring.application.article.ArticleHistoryService;
import io.spring.core.user.User;
import io.spring.domain.article.ArticleHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/article-history")
@AllArgsConstructor
public class ArticleHistoryApi {
    private final ArticleHistoryService articleHistoryService;

    @GetMapping
    public ResponseEntity<?> history(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", defaultValue = "20") int limit,
                                     @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(
                articleHistoryService.findArticleHistory(new Page(offset, limit), user));
    }
}
