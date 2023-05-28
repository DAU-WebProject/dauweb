package com.dauweb.dauweb.dto;

import java.util.List;
public record LunchDto(
        String location1,   // 승학 캠퍼스
        String SPLM_name,   // 승학 캠퍼스 교수회관
        List<String> SPLM,  // 교수회관 메뉴
        String SSLM_name,   // 승학 캠퍼스 학생회관
        List<String> SSLM,  // 학생회관 메뉴
        String SLLM_name,   // 승학 캠퍼스 도서관
        List<String> SLLM,  // 도서관 메뉴
        String location2,   // 부민 캠퍼스
        String BGLM_name,   // 부민 캠퍼스 국제회관
        List<String> BGLM,  // 국제회관 메뉴
        String BTLM_name,   // 부민 캠퍼스 교직원
        List<String> BTLM   // 교직원 메뉴
){

}

