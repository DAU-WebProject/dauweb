package src.main.java.com.dauweb.dauweb.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) throws Exception {
        LocalDate today = LocalDate.now(); // 현재 날짜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String url = "https://donga.ac.kr/gzSub_007005005.aspx?DT=" + today.format(formatter) + "#mt";
        Document doc = Jsoup.connect(url).get();

        // <table> 요소를 찾습니다.
        Elements tableElements = doc.select(".gzTable");

        // <table> 요소의 자식 요소인 <tbody>와 <tr> 요소들을 찾습니다.
        Elements tbodyElements = tableElements.select("tbody");
        Elements trElements = tbodyElements.select("tr");

        // <tr> 요소에서 식단 정보를 추출합니다.
        for (int i = 0; i < trElements.size(); i++) {
            String meal = trElements.get(i).text();
            System.out.println(meal);
        }
    }//
}