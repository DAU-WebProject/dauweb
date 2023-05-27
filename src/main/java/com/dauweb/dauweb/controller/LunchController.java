package com.dauweb.dauweb.controller;

import com.dauweb.dauweb.dto.LunchDto;
import com.dauweb.dauweb.service.LunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/menu")
@Controller
public class LunchController {
    private final LunchService lunchService;

    @GetMapping()
    public String lunchIndex(ModelMap map) throws Exception {
        LunchDto lunchDto = lunchService.getLunchInfo();
        map.addAttribute("lunchdto",lunchDto);

        return "menu/index";
    }
}
