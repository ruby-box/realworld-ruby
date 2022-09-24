package io.spring.application.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.spring.domain.article.ArticleHistory;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticleHistoryDataList {
    @JsonProperty("articleHistoryList")
    private final List<ArticleHistory> articleHistoryList;

    @JsonProperty("articleHistoryCount")
    private final int count;

    public ArticleHistoryDataList(List<ArticleHistory> articleHistoryList, int count) {
        this.articleHistoryList = articleHistoryList;
        this.count = count;
    }
}
