package com.dauweb.dauweb.entity;


import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(exclude = "article")
@NoArgsConstructor
@Entity
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유번호

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Article article;

    @Column(updatable = false)
    private Long parentCommentId; // 부모 댓글 ID를 사용함으로써 해당 컬럼에 데이터가 있으면 대댓글로 구분함.

    @Column(nullable = false, length = 10000)
    private String content; // 내용

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성시간

    @Builder
    public ArticleComment(Long parentCommentId, String content) {
        this.parentCommentId = parentCommentId;
        this.content = content;
    }

}
