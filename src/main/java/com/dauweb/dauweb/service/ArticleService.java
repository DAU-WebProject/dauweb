package com.dauweb.dauweb.service;

import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

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
