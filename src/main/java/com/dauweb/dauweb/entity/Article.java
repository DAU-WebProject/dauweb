package com.dauweb.dauweb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@ToString
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유번호

    @Setter
    @Column(nullable = false)
    private String title; // 제목

    @Setter
    @Column(nullable = false, length = 10000)
    private String content; // 내용

/*
    @Column(nullable = false)
    private String CreatedBy;
*/

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성시간

/*
    @Column(nullable = false)
    private int seq; // 정렬순서
*/

/*
    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();
*/
    @Setter
    @Column(nullable = false)
    private String password; // 수정 삭제 시 pw



}
