package com.dauweb.dauweb.repository;

import com.dauweb.dauweb.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {


        List<ArticleComment> findArticleCommentByArticle(Long articleId);
}
