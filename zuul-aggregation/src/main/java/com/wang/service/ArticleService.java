package com.wang.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.wang.entity.Article;

@FeignClient(name = "article-service")
public interface ArticleService {

	@GetMapping("/articles")
	List<Article> getAllArticles();

	@PostMapping(value = "/article", consumes = "application/json")
	public void publishArticle(@RequestBody Article article);

}
