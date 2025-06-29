package com.management.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.management.app.dto.UserInDto;
import com.management.app.model.User;
import com.management.app.service.UserIService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserIService userIService;
	
//	@PostMapping("save")
//	public String save(@RequestBody UserInDto us) {
//		return userIService.save(us);
//	}
	
	@PostMapping("save")
	public ResponseEntity<String> save(@RequestBody @Valid UserInDto us) {
		return new ResponseEntity<>(userIService.save(us), HttpStatus.OK);
	}
	
	@PutMapping("update")
	public String update(@RequestBody UserInDto us) {
		try {
			return userIService.update(us);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
	@GetMapping("get-all")
	public List<User> getUser(){
		try {
			return userIService.getUser();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ArrayList<User>();
		}
	}
	
	@GetMapping("get-one/{id}")
	public User getOne(@PathVariable("id") Long id) {
		return userIService.getOne(id);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {	
		try {
			userIService.delete(id);
			return "User has been deleted";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	@GetMapping("verification/{email}/{otp}")
	String otpVerification(@PathVariable("email") String email, @PathVariable("otp") int otp) {
		try {
			return userIService.otpVerification(email, otp);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
//	@PatchMapping("otp/{email}")
//	@PatchMapping(value = "otp/{email}")
	@RequestMapping(value = "otp/{email}", method = RequestMethod.PATCH)
	ResponseEntity<String> otpGenerator(@PathVariable("email") String email){

		return new ResponseEntity<>(userIService.otpGenerator(email), HttpStatus.OK);
		
//		try {
//			return userIService.otpGenerator(email);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return e.getMessage();
//		}
		
	}
	
}
