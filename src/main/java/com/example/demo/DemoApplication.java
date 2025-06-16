package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// cria a categoria
		Category c1 = new Category(null, "Mobile");
		Category c2 = new Category(null, "Computers");
		Category c3 = new Category(null, "Electronics");		 

		// cria o produto
		Product p1 = new Product(null, "P1");
		Product p2 = new Product(null, "P2");
		Product p3 = new Product(null, "P3");
		Product p4 = new Product(null, "P4");
		Product p5 = new Product(null, "P5");
		Product p6 = new Product(null, "P6");
		Product p7 = new Product(null, "P7");
		Product p8 = new Product(null, "P8");
		Product p9 = new Product(null, "P9");
		Product p10 = new Product(null, "P10");	
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3)); // Primeiro salva a categoria para depois associar
		
		// associa o produto a categoria
		p1.getCategories().addAll(Arrays.asList(c1, c2));
		p2.getCategories().addAll(Arrays.asList(c1, c3));
		p3.getCategories().addAll(Arrays.asList(c2, c3));
		p4.getCategories().addAll(Arrays.asList(c1, c2));
		p5.getCategories().addAll(Arrays.asList(c2, c3));
		p6.getCategories().addAll(Arrays.asList(c1, c3));
		p7.getCategories().addAll(Arrays.asList(c1));
		p8.getCategories().addAll(Arrays.asList(c3));
		p9.getCategories().addAll(Arrays.asList(c2, c3));
		p10.getCategories().addAll(Arrays.asList(c1, c3));	
		
		//salva o produto por último
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		
	}
}
