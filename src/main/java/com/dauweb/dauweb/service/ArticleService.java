package com.dauweb.dauweb.service;


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

        public boolean saveArticle(Article article) {
        //빈값 체크
        if (article.getTitle() == null || article.getTitle().trim().isEmpty() ||
                article.getContent() == null || article.getContent().trim().isEmpty() ||
                article.getPassword() == null || article.getPassword().trim().isEmpty()) {
            return false;
        }
        articleRepository.save(article);
        return true;
    }

    public ArticleResponseDto findById(Long id) {
        Article entity = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        return new ArticleResponseDto(entity);
    }
}

