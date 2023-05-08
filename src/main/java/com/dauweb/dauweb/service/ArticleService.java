package com.dauweb.dauweb.service;


import com.dauweb.dauweb.dto.ArticleDto;
import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.type.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
//    private final ArticleRepository articleRepository;


    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        if (searchKeyword == null || searchKeyword.isBlank()) {
            Page<Article> articles = articleRepository.findAll(pageable);
            return articles.map(ArticleDto::from);
            // articleRepository.findAll(pageable) -> Page<Article> 반환 이후 map 메서드를 통해 Article을 ArticeDto로 변환해 Page<ArticleDto>가 되는것임.

        }
        return switch (searchType) {
            case TITLE -> articleRepository.findByTitleContaining(searchKeyword, pageable).map(ArticleDto::from);
            case CONTENT -> articleRepository.findByContentContaining(searchKeyword, pageable).map(ArticleDto::from);
        };
    }
}

