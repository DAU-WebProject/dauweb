package com.dauweb.dauweb.repository;


import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends
        JpaRepository<Article,Long>,        // 실제 DB에 Access 하여 쿼리를 수행하는 등의 역할
        QuerydslPredicateExecutor<Article>, // Article 안에있는 기본 검색기능 추가 (부분검색이 안됨)
        QuerydslBinderCustomizer<QArticle>  // 부분검색이 안되는 것을 해결하기 위해 커스터마이징을 함
{
    Page<Article> findByTitleContaining(String title, Pageable pageable);
    Page<Article> findByContentContaining(String content, Pageable pageable);

}

