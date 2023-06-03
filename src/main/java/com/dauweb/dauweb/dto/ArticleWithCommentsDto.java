package com.dauweb.dauweb.dto;

import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.ArticleComment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ArticleWithCommentsDto {
    Long id;
    Set<ArticleCommentDto> articleCommentDtoList;
    String title;
    String content;
    LocalDateTime CreatedAt;
    String password;

    public ArticleWithCommentsDto(Article article){
        id = article.getId();
        articleCommentDtoList = article.getArticleComments().stream().map(ArticleCommentDto::from).collect(Collectors.toSet());
        title = article.getTitle();
        content = article.getContent();
        CreatedAt = article.getCreatedAt();
        password = article.getPassword();
    }
}
