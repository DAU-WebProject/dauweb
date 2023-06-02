package com.dauweb.dauweb.controller;

import com.dauweb.dauweb.dto.LibDto;
import com.dauweb.dauweb.service.CrawlingService;
import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/lib") // 기본 주소
// @Controller
@RestController
public class LibController {
    private final CrawlingService crawlingService;

    @GetMapping()
    public LibDto libIndex(ModelMap map){
        LibDto libDto = crawlingService.getLibInfo();
        map.addAttribute("libdto",libDto);

        return libDto;
    }

}
