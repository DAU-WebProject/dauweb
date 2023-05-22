package com.dauweb.dauweb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유번호

    @Setter
    @ManyToOne(optional = false)
    private Article article;

    @Setter
    @Column(updatable = false)
    private Long parentCommentId; // 부모 댓글 ID를 사용함으로써 해당 컬럼에 데이터가 있으면 대댓글로 구분함.

    @Setter
    @Column(nullable = false, length = 10000)
    private String content; // 내용

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성시간



}
