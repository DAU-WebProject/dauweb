package com.dauweb.dauweb.entity;


import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유번호

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false, length = 10000)
    private String content; // 내용

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성시간

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    @Column(nullable = false)
    private String password; // 수정 삭제 시 pw

    @Builder
    public Article(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
    }

}
