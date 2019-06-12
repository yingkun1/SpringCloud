package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wang.entity.Article;
import com.wang.service.ArticleService;

@RestController
public class ZuulAggController {

	@Autowired
	private ArticleService articleService;
	
	// 服务聚合demo1：调用两次article service，将结果拼接后返回
	@GetMapping("/double-articles")
	List<Article> getDoubleArticles() throws Exception {
		// 通过Spring应用的ApplicationContext对象获取FeignConsumerService Bean
		List<Article> articles1 = articleService.getAllArticles();
		Thread.sleep(10000);
		List<Article> articles2 = articleService.getAllArticles();
		articles1.addAll(articles2);
		return articles1;
	}

}
