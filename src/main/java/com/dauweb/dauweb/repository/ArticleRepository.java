package com.dauweb.dauweb.repository;

import com.dauweb.dauweb.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}