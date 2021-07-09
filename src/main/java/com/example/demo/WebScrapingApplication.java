package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.scraping.Scraping;

@SpringBootApplication
public class WebScrapingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebScrapingApplication.class, args);
		String url = "https://www.alkomprar.com/celulares/telefonos-celulares/c/BI_101?q=%3Arelevance%3Abrand%3AXIAOMI";
		Scraping scraping = new Scraping();
		scraping.url = url;
		//System.out.println(scraping.getHtml(url));
		scraping.scraping();
	}

}
