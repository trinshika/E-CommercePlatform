package com.management.app.service;

import java.util.List;

import com.management.app.model.User;

public interface UserIService {
	
	public User save(User us);
	public List<User> getUser();
	public User getOne(Long id);
	public void delete(Long id);
}
