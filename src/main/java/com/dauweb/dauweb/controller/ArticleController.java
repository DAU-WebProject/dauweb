package com.dauweb.dauweb.controller;

import com.dauweb.dauweb.dto.ArticleDto;
import com.dauweb.dauweb.entity.type.SearchType;
import com.dauweb.dauweb.service.ArticleService;
import com.dauweb.dauweb.service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/articles") // 기본 주소
@Controller
public class ArticleController {

    private final ArticleService articlesService;
    private final PaginationService paginationService;

    @GetMapping
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

    @GetMapping("/")
    public String write() {
        return "articles/index";
    }

    @PostMapping("/write")
    public String post(@ModelAttribute Article article) {
        if (!articleService.saveArticle(article)) {
            return "redirect:/error";
        }
        return "redirect:/";
    }


}
