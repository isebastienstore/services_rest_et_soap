package com.local.webservice;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
//import javax.xml.ws.Endpoint;

@SpringBootApplication
public class WebServiceApplication implements CommandLineRunner{

	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Article> articles = articleRepository.findAll();
		for (Article article: articles){
			System.out.println(article.getTitre()+"\n");
		}
		//Endpoint.publish("http://localhost:3000/", new UserWebService());

		/*
				categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		Category newCategory = new Category();
		newCategory.setName("Promotion");

		newCategory = categoryService.addCategory(newCategory);

		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));
		 */
	}
}
