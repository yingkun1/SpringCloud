package com.wang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.wang.entity.Article;

@Component
public class ArticleServiceHystrixFallback implements ArticleService {

	// 熔断方法，当Article Service不可用时Feign将调用此方法返回结果
	@Override
	public List<Article> getAllArticles() {
		List<Article> list = new ArrayList<Article>();
		
		// 获取断路器状态：
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory.asKey("ArticleService#getAllArticles()"));
		System.out.println("断路器是否断开：" + breaker.isOpen());
		
		Article a = new Article();
		a.setTitle("出错啦");
		a.setBody("真的出错啦，不骗你。断路器是否断开： " + breaker.isOpen());

		list.add(a);
		return list;
	}

	// 熔断方法
	@Override
	public void publishArticle(Article article) {

	}

}
