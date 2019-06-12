package com.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.article.entity.Article;
import com.article.service.ArticleService;

@RestController
public class ProducerService {

	@Value("${server.port}")
	String port;

	@Autowired
	ArticleService articleService;

	@GetMapping("/articles")
	public List<Article> getAllArticles() throws Exception {
		System.out.printf(" getAllArticles is called in port: " + port + "\n");
		// 设置延时，以演示Hystrix功能
		// Thread.sleep(10000);
		// 由于Hystrix设置的超时时间为100ms，这里模拟15-150ms之间的超时
		Thread.sleep((long) ((1+Math.random()*10) * 15));
		return articleService.getAllArticles();
	}

	@PostMapping(value = "/article", consumes = "application/json")
	public void publishArticle(@RequestBody Article article) {
		articleService.insertArticle(article);
		System.out.printf(" publishArticle is called in port: " + port + "\n");
	}
}
