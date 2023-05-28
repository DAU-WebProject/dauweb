package com.dauweb.dauweb.entity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String title, Pageable pageable);
    Page<Article> findByContentContainingIgnoreCaseOrderByCreatedAtDesc(String content, Pageable pageable);

    @Query("Select p From Article p Where p.id > :id")
    public List<Article> selectById(@Param(value="id") Long id);
}
