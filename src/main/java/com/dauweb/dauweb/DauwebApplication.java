package com.dauweb.dauweb;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.StringBuilder;
import java.lang.String;

@SpringBootApplication
public class DauwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DauwebApplication.class, args);
	}

}
