package com.management.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ECommercePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformApplication.class, args);
	}

}
