package com.dauweb.dauweb.service;

import com.dauweb.dauweb.dto.LunchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class LunchService {
    public LunchDto getLunchInfo() throws Exception{
        LocalDate today = LocalDate.now(); // 현재 날짜
        //LocalDate tom = LocalDate.of(2023,05,30); //주말일 경우 확인용 날짜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String url = "http://donga.ac.kr/gzSub_007005005.aspx?DT=" + today.format(formatter) + "#mt";
        Connection connection = Jsoup.connect(url);
        Document doc = connection.get();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        // <table> 요소를 찾습니다.
        Elements tableElements = doc.select(".gzTable");

        // <table> 요소의 자식 요소인 <tbody>와 <tr> 요소들을 찾습니다.
        Elements tbodyElements = tableElements.select("tbody");
        Elements trElements = tbodyElements.select("tr");

        //승학과 부민 나눠서 저장할 리스트
        List<String> SHLunch = new ArrayList<>();
        List<String> BMLunch = new ArrayList<>();

        // <tr> 요소에서 식단 정보를 추출합니다. -> 필요없는 정보를 제거하고 정식부분만 정리
        for (int i = 0; i < trElements.size(); i++) {
            String meal = trElements.get(i).text();
            if(i == 5){
                SHLunch = Arrays.asList(meal.split("영업시간 "));
            }
            if(i == 9){
                BMLunch = Arrays.asList(meal.split("영업시간 "));
            }
        }

        /*
        String PLMString = new String();
        String SLMString = new String();
        String LLMString = new String();
        // 문자열로 보낼려고 할때
        for (int i = 0; i < SHLunch.size();i++){
            if(i == 1){
                PLMString = SHLunch.get(i);
            }
            if(i == 2){
                SLMString = SHLunch.get(i)+SHLunch.get(i+1);
            }
            if(i == 4){
                LLMString = SHLunch.get(i);
            }
        }
        */

        String location1 = new String("승학캠퍼스");
        String SPLM_name = new String();
        String SSLM_name = new String();
        String SLLM_name = new String();
        List<String> SPLM = new ArrayList<>();
        List<String> SSLM1 = new ArrayList<>();
        List<String> SSLM2 = new ArrayList<>();
        List<String> SLLM = new ArrayList<>();

        // 승학캠퍼스 자료 리스트로 보내기 위해 자르는 구간
        for (int i = 0; i < SHLunch.size();i++){
            if(i == 1){
                SPLM_name = "교수회관";
                SPLM = Arrays.asList(SHLunch.get(i).split(" "));
            }
            if(i == 2){
                SSLM_name = "학생회관";
                SSLM1 = Arrays.asList(SHLunch.get(i).split(" "));
            }
            if(i == 3){
                SSLM2 = Arrays.asList(SHLunch.get(i).split(" "));

            }
            if(i == 4){
                SLLM_name = "도서관";
                SLLM = Arrays.asList(SHLunch.get(i).split(" "));
            }
        }
        List<String> SSLM = Stream.concat(SSLM1.stream(), SSLM2.stream()).collect(Collectors.toList());

        // 부민캠퍼스 자료 리스트로 보내기 위해 자르는 구간
        String location2 = new String("부민캠퍼스");
        String BGLM_name = new String();
        String BTLM_name = new String();
        List<String> BGLM = new ArrayList<>();
        List<String> BTLM = new ArrayList<>();

        for (int i = 0; i < BMLunch.size();i++){
            if(i == 0){
                BGLM_name = "국제회관 기숙사";
                BGLM = Arrays.asList(BMLunch.get(i).split(" "));
            }
            if(i == 1) {
                BTLM_name = "교직원";
                BTLM = Arrays.asList(BMLunch.get(i).split(" "));
            }
        }

        /* 확인용 출력문들
        System.out.println("교수회관");
        for (String lunch : PLM){
            System.out.println(lunch);
        }
        System.out.println("\n학생회관");
        for (String lunch : SLM){
            System.out.println(lunch);
        }
        System.out.println("\n도서관");
        for (String lunch : LLM){
            System.out.println(lunch);
        }

        System.out.println("\n------------");

        for (String lunch : BMLunch){
            System.out.println(lunch);
        }
        */


        LunchDto lunchDto = new LunchDto(location1,SPLM_name,SPLM,SSLM_name,SSLM,SLLM_name,SLLM,location2,BGLM_name,BGLM,BTLM_name,BTLM);
        return lunchDto;
    }
}
