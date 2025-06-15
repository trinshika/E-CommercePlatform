package com.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.app.model.User;
import com.management.app.repo.UserIRepo;

@Service
public class UserServiceImpl implements UserIService {

	@Autowired
	UserIRepo userIRepo;
	
	public User save(User us) {
		return userIRepo.save(us);
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
