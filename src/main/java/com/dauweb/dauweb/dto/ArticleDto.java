package com.dauweb.dauweb.dto;

import com.dauweb.dauweb.entity.Article;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public record ArticleDto(
        Long id,
        String title,
        String content,
        LocalDateTime CreatedAt,
        int seq,
        String password
) {


    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getSeq(),
                entity.getPassword()
        );
    }
}
