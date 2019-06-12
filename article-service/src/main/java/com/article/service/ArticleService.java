package com.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.article.entity.Article;
import com.article.repository.ArticleRep;

@Service
public class ArticleService {
	@Autowired
	ArticleRep articleRep;

	public List<Article> getAllArticles() {
		return articleRep.findAll();
	}

	public void insertArticle(Article article) {
		articleRep.save(article);
	}
}
