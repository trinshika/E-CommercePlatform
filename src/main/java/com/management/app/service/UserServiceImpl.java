
package com.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.app.dto.UserInDto;
import com.management.app.model.User;
import com.management.app.repo.UserIRepo;
import com.management.app.util.EmailIUtil;
import com.management.app.util.EmailTemplate;
import com.management.app.util.OtpIgenerator;

@Service
public class UserServiceImpl implements UserIService {

	@Autowired
	UserIRepo userIRepo;

	@Autowired
	OtpIgenerator og;

	@Autowired
	EmailIUtil eu;
	
	@Autowired
	EmailTemplate emailTemplate;

	public String save(UserInDto us) {

		if(userIRepo.findByEmail(us.getEmail()).size() != 0) 
			return "User already exist";

		int otp = og.sixDigitOtp();

		User u = new User(us.getId(), 
				us.getName(), 
				us.getEmail(), 
				us.getPassword(), 
				us.getRole(),
				us.getGender(),
				otp, 
				false);

		userIRepo.save(u);
		eu.sendMail(us.getEmail(), "Account Creation Confirmation & OTP Verification", emailTemplate.getMailBodyAccountCreation(us.getGender(), us.getName(), otp, us.getEmail()));
		return "User saved succesfully";
	}


	public String update(UserInDto us) {

		User u = new User(us.getId(), 
				us.getName(), 
				us.getEmail(), 
				us.getPassword(), 
				us.getRole(),
				us.getGender(),
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


	public String otpVerification(String email, int otp) {
		List<User> user = userIRepo.findByEmailAndOtp(email, otp);

		if (user.isEmpty()) {
			List<User> us = userIRepo.findByEmail(email);
			if(!us.isEmpty()) {
				eu.sendMail(email, "Account verification mail test", emailTemplate.getMailBodySecurityThread(us.get(0).getGender(), us.get(0).getName(), otp));
			}
			return "Varification failed !!!";
		}else {	
			User us = user.get(0);
			
			if(us.isVerified()) {
				return "User is already verified";
			}
			
			us.setVerified(true);
			userIRepo.save(us);
			eu.sendMail(email, "Account verification mail test", emailTemplate.getMailBodyVerificationSuccess(us.getGender(), us.getName()));
			return "Verification success !!!";
		}
	}

	public String otpGenerator(String email) {
		List<User> user = userIRepo.findByEmail(email);
		if(!user.isEmpty()) {
			int otp = og.sixDigitOtp();
			User us = user.get(0);
			us.setOtp(otp);
			userIRepo.save(us);
			eu.sendMail(email, "OTP Regenerated – Complete Your Verification", emailTemplate.getMailBodyOtpRegenerated(us.getGender(), us.getName(), us.getOtp(), us.getEmail()));
			return "OTP sent via registered email";
		}else {
			return "User not found";
		}
	}


}
