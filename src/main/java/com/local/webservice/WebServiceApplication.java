package com.local.webservice;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.List;
//import javax.xml.ws.Endpoint;

@SpringBootApplication
@Transactional
public class WebServiceApplication implements CommandLineRunner{

	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello !\n L'application a démaré avec sucès !!!");
	}
}
