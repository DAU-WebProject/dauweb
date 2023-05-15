package com.dauweb.dauweb.controller;

import com.dauweb.dauweb.entity.Article;
import com.dauweb.dauweb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String write() {
        return "index";
    }

    @PostMapping("/write")
    public String post(@ModelAttribute Article article) {
        if (!articleService.saveArticle(article)) {
            return "redirect:/error";
        }
        return "redirect:/";
    }
}

