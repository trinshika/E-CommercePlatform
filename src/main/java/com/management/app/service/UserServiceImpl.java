package com.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.app.dto.UserInDto;
import com.management.app.model.User;
import com.management.app.repo.UserIRepo;
import com.management.app.util.OtpIgenerator;

@Service
public class UserServiceImpl implements UserIService {

	@Autowired
	UserIRepo userIRepo;
	
	@Autowired
	OtpIgenerator og;
	
	public String save(UserInDto us) {
		
		User u = new User(us.getId(), 
				us.getName(), 
				us.getEmail(), 
				us.getPassword(), 
				us.getRole(), 
				og.eigthDigitOtp(), 
				false);
		
		
		userIRepo.save(u);
		
		return "User saved succesfully";
	}
	
	
	public String update(UserInDto us) {
			
			User u = new User(us.getId(), 
					us.getName(), 
					us.getEmail(), 
					us.getPassword(), 
					us.getRole(), 
					1234, 
					false);
		
		
		userIRepo.save(u);
		
		return "User Updated succesfully";
	}
	
	
	public List<User> getUser(){
		return userIRepo.findAll();
	}
	
	public User getOne(Long id) {
		return userIRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		userIRepo.deleteById(id);
	}
}
