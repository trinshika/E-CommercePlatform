package com.management.app.controller;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.management.app.dto.PasswordDto;
import com.management.app.dto.UserInDto;
import com.management.app.model.User;
import com.management.app.service.UserIService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

	@Autowired
	UserIService userIService;
	
//	@PostMapping("save")
//	public String save(@RequestBody UserInDto us) {
//		return userIService.save(us);
//	}
	
	@PostMapping("save")
	public ResponseEntity<String> save(@RequestBody @Valid UserInDto us) throws JsonMappingException, JsonProcessingException {
		log.info("Entered into user/Save controller");
		log.debug("user data" + us.toString());
		return new ResponseEntity<>(userIService.save(us), HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> update(@RequestBody UserInDto us) {
		log.info("Entered into user/Update controller");
		log.debug("user data" + us.toString());
			return new ResponseEntity<>(userIService.update(us), HttpStatus.OK);
	}
	
	@GetMapping("get-all")
	public ResponseEntity<List<User>> getUser(){
		log.info("Entered into user/get-all controller");
		return new ResponseEntity<>(userIService.getUser(),HttpStatus.OK);
	}
	
	@GetMapping("get-one/{id}")
	public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
		log.info("Entered into user/get-one controller");
	
		return new ResponseEntity<>(userIService.getOne(id),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		log.info("Entered into user/Delete controller");
		
			userIService.delete(id);
		return new ResponseEntity<>("User has been deleted" ,HttpStatus.OK);
	}	//return "User has been deleted";
	
	@GetMapping("verification/{email}/{otp}")
	public ResponseEntity<String> otpVerification(@PathVariable("email") String email, @PathVariable("otp") int otp) {
		log.info("Entered into user/otpVerification controller");
		log.debug("user email, otp: " + email, otp);
		return new ResponseEntity<>(userIService.otpVerification(email, otp),HttpStatus.OK);
	
	}
	
	
//	@PatchMapping("otp/{email}")
//	@PatchMapping(value = "otp/{email}")
	@RequestMapping(value = "otp/{email}", method = RequestMethod.PATCH)
	ResponseEntity<String> otpGenerator(@PathVariable("email") String email){
		log.info("Entered into user/otpGenerator controller");
		log.debug("user email: " + email);
		return new ResponseEntity<>(userIService.otpGenerator(email), HttpStatus.OK);
		
//		try {
//			return userIService.otpGenerator(email);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return e.getMessage();
//		}
		
	}
	
	@PutMapping("update-password")
	public ResponseEntity<String> updatePassword(@RequestBody @Valid PasswordDto passwordDto) {
		log.info("Entered into user/updatePassword controller");
		log.debug("user data" + passwordDto.toString());
		return new ResponseEntity<>(userIService.updatePassword(passwordDto), HttpStatus.OK);
	
	}
	
	
}
