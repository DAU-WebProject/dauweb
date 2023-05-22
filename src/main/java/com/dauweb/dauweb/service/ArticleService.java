package com.dauweb.dauweb.service;


import com.dauweb.dauweb.dto.ArticleDto;
import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.type.SearchType;
import com.dauweb.dauweb.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            // articleRepository.findAll(pageable) -> Page<Article> 반환 이후 map 메서드를 통해 Article을 ArticeDto로 변환해 Page<ArticleDto>가 되는것임.

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
}

