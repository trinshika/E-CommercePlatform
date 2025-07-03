package com.management.app.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.management.app.model.User;
import com.management.app.service.UserIService;
import com.management.app.util.EmailIUtil;

@Component
public class UserScheduler {
	
	@Autowired
	EmailIUtil emailUtil;
	
	@Autowired
	UserIService userService;

	//	@Scheduled(fixedRate = 5000)
	//	public void test() {
	//		System.out.println("hello");
	//	}

//	@Scheduled(cron = "*/10 * * * * *")
//	public void test() {	
//		List<User> user = userService.getUser();
//		
//		for (User us : user) {
//			emailUtil.sendMail(us.getEmail(), "Weekend offer", "weekend offer");
//		}	
//		
//	}

	
//	indepandance day
//	birthday
//	x-mas
//	festival
//	anniversary
//	6m password reset
//	1m offer
//	3m season offers
//	weekly offer

}
