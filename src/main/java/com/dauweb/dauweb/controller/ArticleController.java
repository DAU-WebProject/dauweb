package com.dauweb.dauweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import com.dauweb.dauweb.dto.ArticleDto;
import com.dauweb.dauweb.dto.ArticleResponseDto;
import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.entity.type.SearchType;
import com.dauweb.dauweb.service.ArticleService;
import com.dauweb.dauweb.service.PaginationService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/articles") // 기본 주소
// @Controller
@RestController
public class ArticleController {

    private final ArticleService articlesService;
    private final PaginationService paginationService;

    @GetMapping()
    public Page<ArticleDto> articles(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size=10, sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map) {

        Page<ArticleDto> articles = articlesService.searchArticles(searchType,searchValue,pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumbers(pageable.getPageNumber(),articles.getTotalPages());

        map.addAttribute("articles", articles);
        map.addAttribute("paginationBarNumbers",barNumbers);

        return articles;
    }

    @GetMapping("/view/{id}")
    public ArticleResponseDto articleView(@PathVariable Long id, Model model) {
        ArticleResponseDto dto = articlesService.findById(id);

        System.out.println(dto.getContent());

        model.addAttribute("title", dto.getTitle());
        model.addAttribute("content", dto.getContent());
        model.addAttribute("id", dto.getId());
        model.addAttribute("createdAt", dto.getCreatedAt());
        model.addAttribute("password", dto.getPassword());
        return dto;
    }

    @GetMapping("/write")
    public String write() {
        return "articles/index";
    }

    @PostMapping("/write")
    public ResponseEntity<?> post(@RequestBody ArticleResponseDto articleResponseDto) throws IOException {
        if (!articlesService.saveArticle(articleResponseDto)) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true); // 정상적인 결과가 반환됐을 때, 게시글리스트로 가야 함.
    }


}
