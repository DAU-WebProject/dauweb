package com.dauweb.dauweb.service;


import com.dauweb.dauweb.dto.LibDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class CrawlingService {

    public LibDto getLibInfo(){

        String rootPath = System.getProperty("user.dir");
        String driverPath = rootPath + "\\lib\\chromedriver.exe";
        //드라이버 설치 후 경로 수정 필요
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless"); // 브라우저 창을 숨김
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("http://library.donga.ac.kr/libaray-services/facilities/reading-room/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String html = driver.getPageSource();
        Document doc = Jsoup.parse(html);
        //  동아대 도서관 열람실 이용 홈페이지 불러오기

        Elements e0 = doc.getElementsByAttributeValue("class", "con-title");
        System.out.println(e0.text()+'\n');
        String title = e0.text();
        // 대주제

        Elements e1 = doc.getElementsByAttributeValue("class", "data-title line");
        System.out.println(e1.get(0).text()+'\n');
        String subTitle = e1.get(0).text();
        // 소주제

        Elements thElements = doc.select("thead th");
        List<String> headerList = new ArrayList<>();
        for (Element thElement : thElements) {
            String header = thElement.text();
            headerList.add(header);
        }
        // 헤더

        Elements TableBody = doc.select("div>table>tbody");
        List<String> t_body = new ArrayList<>();
        // 테이블 바디

        for (Element element : TableBody) {
            int count = 0;
            for (Element td : element.select("tr")) {
                t_body.add(td.text());
                count++;
                if (count >= 7)
                    break;
            }
            if (count >= 7)
                break;
        }
        System.out.println("==============================");
        System.out.println(t_body);
        // 표의 나머지 내용, 승학까지만 출력
//        1 한림그룹스터디실(3층) 40 40 0 100%
//        2 한림열람실A(3층) 86 25 61 29.07%
//        3 한림열람실B(3층) 92 15 77 16.3%
//        4 한림열람실C(3층) 118 39 79 33.05%
//        5 한림열람실D(3층) 78 8 70 10.26%
//        6 한림열람실E(3층) 77 3 74 3.9%
//        7 한림노트북열람실(3층) 48 10 38 20.83%

        Elements e3 = TableBody.select("[href]");
        List<String> link = new ArrayList<>();
        int count = 0;
        for(Element element : e3) {
            link.add(element.attr("href"));
            count ++;
            if (count >= 7)
                break;
        }
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=1
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=2
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=3
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=4
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=5
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=6
//        http://168.115.33.202:8080/WebSeat/roomview5.asp?room_no=7
        // 열람실별 좌석배정현황, 승학까지만 출력


        // 열람실 이용 안내 내용
        driver.quit();
        LibDto libDto = new LibDto(title,subTitle,headerList,t_body,link);
        return libDto;
    }
}
