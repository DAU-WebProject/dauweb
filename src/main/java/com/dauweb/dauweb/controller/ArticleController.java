package com.dauweb.dauweb.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
@Controller
public class ArticleController {

    private final ArticleService articlesService;
    private final PaginationService paginationService;

    @GetMapping()
    public String articles(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size=10, sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map) {

        Page<ArticleDto> articles = articlesService.searchArticles(searchType,searchValue,pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumbers(pageable.getPageNumber(),articles.getTotalPages());

        map.addAttribute("articles", articles);
        map.addAttribute("paginationBarNumbers",barNumbers);

        return "articles/index";
    }

    @GetMapping("/view/{id}")
    public String articleView(@PathVariable Long id, Model model) {
        ArticleResponseDto dto = articlesService.findById(id);

        System.out.println(dto.getContent());

        model.addAttribute("title", dto.getTitle());
        model.addAttribute("content", dto.getContent());
        model.addAttribute("id", dto.getId());
        model.addAttribute("createdAt", dto.getCreatedAt());
        model.addAttribute("password", dto.getPassword());
        return "articles/view";
    }

    @GetMapping("/write")
    public String write() {
        return "articles/index";
    }

    @PutMapping("/write")
    public String post(@RequestBody Article article) {
        if (!articlesService.saveArticle(article)) {
            return "redirect:/error";
        }
        return "redirect:/";
    }


}
