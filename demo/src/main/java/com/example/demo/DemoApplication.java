package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner categorycl(CategoryRepository repository) {
		return (args) -> {
			Category a = new Category("scifi");
			Category b = new Category("comic");
			
			repository.save(a);
			repository.save(b);
		};
	}
	
	@Bean
	public CommandLineRunner bookcl(BookRepository repository) {
		return (args) -> {
			Book a = new Book("Petteri Perä", "Hello World", 1999, "894098-5432", 9);
			
			repository.save(a);
		};
	}
}
