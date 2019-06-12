package com.feigndemo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feigndemo.entity.Article;

@RestController
@FeignClient(name = "article-service")
public interface FeignConsumerService {

	@GetMapping("/articles")
	List<Article> getAllArticles();

	@PostMapping(value = "/article", consumes = "application/json")
	public void publishArticle(@RequestBody Article article);

}
