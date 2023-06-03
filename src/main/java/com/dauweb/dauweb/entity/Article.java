package com.dauweb.dauweb.entity;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유번호

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false, length = 10000)
    private String content; // 내용

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 작성시간

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @JsonIgnore
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    @Column(nullable = false)
    private String password; // 수정 삭제 시 pw


}