package com.okta.springbootjpa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Bean
	ApplicationRunner init(KayakRepository repository) {

		String[][] data = {
				{"sea", "Andrew", "300.12", "2,2,2", "1580684400000"},
				{"creek", "Andrew", "100.75", "Piranha", "1581462000000"},
				{"loaner", "Andrew", "75", "Necky", "1581462000000"}
		};

		return args -> {
			Stream.of(data).forEach(array -> {
				try {
					Kayak kayak = new Kayak(
							array[0],
							array[1],
							NumberFormat.getInstance().parse(array[2]),
							array[3],
							Long.parseLong(array[4])
					);
					repository.save(kayak);
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			});
			repository.findAll().forEach(System.out::println);
		};
	}
	
}
