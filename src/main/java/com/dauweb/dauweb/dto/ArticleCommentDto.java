package com.dauweb.dauweb.dto;

import com.dauweb.dauweb.entity.ArticleComment;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public record ArticleCommentDto(
        Long id,
        Long articleId,
        Long parentCommentId,
        String content,
        LocalDateTime CreatedAt
) {

    public static ArticleCommentDto of(Long articleId,  String content) {
        return ArticleCommentDto.of(null,articleId, null, content, null);
    }

    public static ArticleCommentDto of(Long articleId,  Long parentCommentId, String content) {
        return ArticleCommentDto.of(null, articleId, parentCommentId, content, null);
    }

    public static ArticleCommentDto of(Long id, Long articleId,  Long parentCommentId, String content, LocalDateTime createdAt) {
        return new ArticleCommentDto(id, articleId, parentCommentId, content, createdAt);
    }

    public static ArticleCommentDto from(ArticleComment entity) {
        return new ArticleCommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                entity.getParentCommentId(),
                entity.getContent(),
                entity.getCreatedAt()
        );
    }


}
