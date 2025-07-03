package com.management.app.onstartup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.management.app.dto.UserInDto;
import com.management.app.service.UserIService;
import com.management.app.util.EmailIUtil;

@Component
public class UserData implements ApplicationRunner{

	@Autowired
	UserIService userService;
	
	@Autowired
	EmailIUtil emailUtil;
	
	@Value("${app.baseurl}")
	private String baseurl;
	
	@Value("${spring.application.name}")
	private String appName;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Base url ::: " + baseurl);
		System.out.println("appName ::: " + appName);

//		System.out.println("User data insertion start");
//		
//		userService.save(new UserInDto(null, "Trinshika", "trinshika@gmail.com", "1234567", "female", "admin"));
//		userService.save(new UserInDto(null, "Aryan", "aryan001@gmail.com", "pass789", "male", "user"));
//		userService.save(new UserInDto(null, "Neha", "neha.kumari@example.com", "neha123", "female", "user"));
//		userService.save(new UserInDto(null, "Rahul", "rahul.raj@example.com", "rahul456", "male", "admin"));
//		userService.save(new UserInDto(null, "Simran", "simran12@example.com", "simi789", "female", "user"));
//		userService.save(new UserInDto(null, "Vikram", "vikram_singh@example.com", "vikram321", "male", "user"));
//		userService.save(new UserInDto(null, "Pooja", "pooja.sharma@example.com", "poo123", "female", "user"));
//		userService.save(new UserInDto(null, "Rohan", "rohan.das@example.com", "rohan111", "male", "admin"));
//		userService.save(new UserInDto(null, "Anjali", "anjali.k@example.com", "anjali@22", "female", "user"));
//		userService.save(new UserInDto(null, "Karan", "karan007@example.com", "karan007", "male", "user"));
//
//		System.out.println("User data insertion end");
		
//		emailUtil.sendMail("trinshika@gmail.com", "Application started", "<h1>Application started and 10 record inserted</h1>");
	}

}
//1. implement ApplicationRunner
//2. Override run method
