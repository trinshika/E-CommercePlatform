package com.management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.app.dto.UserInDto;
import com.management.app.model.User;
import com.management.app.service.UserIService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserIService userIService;
	
	@PostMapping("save")
	public String save(@RequestBody UserInDto us) {
		return userIService.save(us);
	}
	
	@PutMapping("update")
	public String update(@RequestBody UserInDto us) {
		return userIService.update(us);
	}
	
	@GetMapping("get-all")
	public List<User> getUser(){
		return userIService.getUser();
	}
	
	@GetMapping("get-one/{id}")
	public User getOne(@PathVariable("id") Long id) {
		return userIService.getOne(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userIService.delete(id);
	}
}
