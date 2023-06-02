package com.dauweb.dauweb.dto;

import java.time.LocalDateTime;

import com.dauweb.dauweb.entity.Article;

import lombok.Getter;

@Getter

public class ArticleResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime CreatedAt;
    private String password;

    public ArticleResponseDto(Article entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.CreatedAt = entity.getCreatedAt();
        this.password = entity.getPassword();
    }
}
