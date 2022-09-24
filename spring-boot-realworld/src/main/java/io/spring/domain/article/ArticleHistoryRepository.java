package io.spring.domain.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleHistoryRepository extends JpaRepository<ArticleHistory, Long> {
    List<ArticleHistory> findByUserId(String user_id);

    int countByUserId(String user_id);
}
