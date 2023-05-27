package com.dauweb.dauweb.dto;

import java.util.List;
public record LunchDto(
        String location1,
        String SPLM_name,
        List<String> SPLM,
        String SSLM_name,
        List<String> SSLM,
        String SLLM_name,
        List<String> SLLM,
        String location2,
        String BGLM_name,
        List<String> BGLM,
        String BTLM_name,
        List<String> BTLM
){

}

