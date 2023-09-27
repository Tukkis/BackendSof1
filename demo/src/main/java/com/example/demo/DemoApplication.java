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
	public CommandLineRunner categorycl(CategoryRepository crepository, BookRepository brepository) {
		return (args) -> {
			Category a1 = new Category("scifi");
			Category b1 = new Category("comic");
			
			crepository.save(a1);
			crepository.save(b1);

			Book b2 = new Book("Petteri Perä", "Hello World", 1999, "894098-5432", 9, crepository.findByName("comic").get(0));
			
			brepository.save(b2);
		};
	}
}
