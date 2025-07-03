package com.management.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.management.app.dto.PasswordDto;
import com.management.app.dto.UserInDto;
import com.management.app.model.User;

public interface UserIService {
	
	public String save(UserInDto us) throws JsonMappingException, JsonProcessingException ;
	public String update(UserInDto us);
	public List<User> getUser();
	public User getOne(Long id);
	public void delete(Long id);
	public String otpGenerator(String email);
	public String otpVerification(String email, int otp);
	public String updatePassword(PasswordDto passwordDto);
	
}
