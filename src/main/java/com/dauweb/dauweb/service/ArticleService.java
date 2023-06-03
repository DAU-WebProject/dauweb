package com.dauweb.dauweb.service;


import com.dauweb.dauweb.dto.ArticleWithCommentsDto;
import com.dauweb.dauweb.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dauweb.dauweb.dto.ArticleDto;
import com.dauweb.dauweb.dto.ArticleResponseDto;
import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.type.SearchType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    @Autowired
    private final ArticleRepository articleRepository;


    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        if (searchKeyword == null || searchKeyword.isBlank()) {
            Page<Article> articles = articleRepository.findAll(pageable);
            return articles.map(ArticleDto::from);
        }
        return switch (searchType) {
            case TITLE -> articleRepository.findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(searchKeyword, pageable).map(ArticleDto::from);
            case CONTENT -> articleRepository.findByContentContainingIgnoreCaseOrderByCreatedAtDesc(searchKeyword, pageable).map(ArticleDto::from);
        };
    }


    @Transactional
    public boolean saveArticle(ArticleResponseDto articleResponseDto) throws IOException {

    //빈값 체크
    if (articleResponseDto.getTitle() == null || articleResponseDto.getTitle().trim().isEmpty() ||
            articleResponseDto.getContent() == null || articleResponseDto.getContent().trim().isEmpty() ||
            articleResponseDto.getPassword() == null || articleResponseDto.getPassword().trim().isEmpty()) {
        return false;
    }
    Article article = Article.builder()
            .title(articleResponseDto.getTitle())
            .content(articleResponseDto.getContent())
            .password(articleResponseDto.getPassword())
            .build();

    articleRepository.save(article);
    return true;
    }
    

    @Transactional
    public ArticleWithCommentsDto findById(Long id) {
        Article entity = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        return new ArticleWithCommentsDto(entity);
    }
}

