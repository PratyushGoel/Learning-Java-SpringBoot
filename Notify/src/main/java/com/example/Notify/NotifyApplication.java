package com.example.Notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EnableMongoAuditing // For creation timestamp
public class NotifyApplication {

	public static void main(String[] args) {

		SpringApplication.run(NotifyApplication.class, args);
	}

}
