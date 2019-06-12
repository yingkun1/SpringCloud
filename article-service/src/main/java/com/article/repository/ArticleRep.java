package com.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.article.entity.Article;

@Repository
public interface ArticleRep extends JpaRepository<Article,Long>  {

}
