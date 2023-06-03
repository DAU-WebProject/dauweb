package com.dauweb.dauweb.dto;

import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.ArticleComment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
public class ArticleWithCommentsDto {
    Long id;
    Set<ArticleComment> articleCommentDtoList;
    String title;
    String content;
    LocalDateTime CreatedAt;
    String password;

    public ArticleWithCommentsDto(Article article){
        id = article.getId();
        articleCommentDtoList = article.getArticleComments();
        title = article.getTitle();
        content = article.getContent();
        CreatedAt = article.getCreatedAt();
        password = article.getPassword();
    }
}
