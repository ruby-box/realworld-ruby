package io.spring.application.data;

import io.spring.application.DateTimeCursor;
import io.spring.application.PageCursor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Lob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleHistoryData implements io.spring.application.Node {
    private Long id;
    private String userId;
    private String articleId;
    private String slug;
    private String title;
    private String description;
    private String body;
    private String mode;
    private DateTime createdAt;

    @Override
    public PageCursor getCursor() {
        return new DateTimeCursor(createdAt);
    }
}
