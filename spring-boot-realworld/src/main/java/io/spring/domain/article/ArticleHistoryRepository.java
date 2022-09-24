package io.spring.domain.article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleHistoryRepository extends JpaRepository<ArticleHistory, Long> {
}
