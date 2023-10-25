package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner categorycl(CategoryRepository crepository, BookRepository brepository, UserRepository urepository) {
		return (args) -> {
			Category a1 = new Category("scifi");
			Category b1 = new Category("comic");
			
			crepository.save(a1);
			crepository.save(b1);

			Book b2 = new Book("Petteri Perä", "Hello World", 1999, "894098-5432", 9, crepository.findByName("comic").get(0));
			
			brepository.save(b2);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "a@b.c", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "a@b.c", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
