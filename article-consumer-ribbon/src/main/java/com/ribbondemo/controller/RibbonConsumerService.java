package com.ribbondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonConsumerService {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/test")
	public String callProducer() {
		ResponseEntity<String> result = this.restTemplate.getForEntity("http://article-service/articles", String.class,
				"");
		if (result.getStatusCode() == HttpStatus.OK) {
			// System.out.printf(result.getBody() + " called in callProducer");
			return result.getBody();
		} else {
			// System.out.printf(" is it empty? ");
			return " empty ";
		}
	}
}
