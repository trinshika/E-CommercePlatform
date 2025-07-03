
package com.management.app.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.management.app.dto.PasswordDto;
import com.management.app.dto.UserInDto;
import com.management.app.exception.OldPasswordNotMatchedException;
import com.management.app.exception.UserAlreadyExistException;
import com.management.app.exception.UserNotFoundException;
import com.management.app.exception.VerificationAlreadyDoneException;
import com.management.app.exception.VerificationFailedException;
import com.management.app.mapper.UserMapper;
import com.management.app.model.User;
import com.management.app.repo.UserIRepo;
import com.management.app.util.EmailIUtil;
import com.management.app.util.EmailTemplate;
import com.management.app.util.OtpIgenerator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserIService {

	@Autowired
	UserIRepo userIRepo;

	@Autowired
	OtpIgenerator og;

	@Autowired
	EmailIUtil eu;

	@Autowired
	EmailTemplate emailTemplate;

	@Autowired
	UserMapper userMapper;

	public String save(UserInDto us) throws JsonMappingException, JsonProcessingException {
		log.info("entered into user service save method");
		log.debug("user data" + us.toString());
		if(!userIRepo.findByEmail(us.getEmail()).isEmpty()) {
			log.warn("user already exist with email id : " + us.getEmail());
			log.error("before throwing UserAlreadyExistException");
			throw new UserAlreadyExistException("User already exist with email id : " + us.getEmail());
		}


		User u = userMapper.UserInDtoToUserEntity(us);

		log.debug("mapper user : " + u.toString());

		int otp = og.sixDigitOtp();

		log.debug("generated otp : " + otp);
		u.setOtp(otp);

		log.info("before calling userRepo.save method");
		log.debug("User data: " + u.toString());
		userIRepo.save(u);

		log.info("user saved and mail triggered");
		eu.sendMail(us.getEmail(), "Account Creation Confirmation & OTP Verification", emailTemplate.getMailBodyAccountCreation(us.getGender(), us.getName(), otp, us.getEmail()));

		log.info("before returning from user service save method");
		return "User saved succesfully";
	}


	public String update(UserInDto us) {
		log.info("entered into user service update method");
		log.debug("user data" + us.toString());
		userIRepo.updateUser(us.getName(), us.getRole(), us.getGender(), us.getId());

		log.info("user updated and mail triggered");
		eu.sendMail(userIRepo.findById(us.getId()).get().getEmail(), "User has been updated successfully", "You account has been updated successfully");

		log.info("before returning from user service update method");
		return "User Updated succesfully";
	}


	public List<User> getUser(){
		log.info("entered into user service getUser method");
		log.info("before returning from user service getUser method");
		return userIRepo.findAll();
	}

	public User getOne(Long id) {
		log.info("entered into user service getOne method");
		try {
			log.info("entered into try block");
			return userIRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			log.error("before throwing NoSuchElementException");
			throw new UserNotFoundException("Requested user is not available " + id);	
		}
	}

	public void delete(Long id) {
		log.info("entered into user service delete method");
		userIRepo.deleteById(id);
	}


	public String otpVerification(String email, int otp) {
		log.info("entered into user service otpVerification method");
		List<User> user = userIRepo.findByEmailAndOtp(email, otp);
		
		log.debug("user data" + user.toString());

		if (user.isEmpty()) {
			log.warn("user not found with email, otp : " + email, otp);
			List<User> us = userIRepo.findByEmail(email);
			
			if(!us.isEmpty()) {
				log.warn("user not found with email : " + email);
				log.error("before throwing VerificationFailedException");
				
				eu.sendMail(email, "Account verification mail test", emailTemplate.getMailBodySecurityThread(us.get(0).getGender(), us.get(0).getName(), otp));
				throw new VerificationFailedException("verification has been failed!!! : " + email);
			}
			
			log.error("before throwing UserNotFoundException");
			throw new UserNotFoundException("User not found : " + email);
		}else {	
			User us = user.get(0);

			if(us.getVerified()) {
				log.error("Verification already done exception");
				throw new  VerificationAlreadyDoneException("verification has already done. : " + email);
			}

			//			us.setVerified(true);
			//userIRepo.save(us);

			userIRepo.updateVerification(true,email);
			eu.sendMail(email, "Account verification mail test", emailTemplate.getMailBodyVerificationSuccess(us.getGender(), us.getName()));
			return "Verification success !!!";
		}
	}

	public String otpGenerator(String email) {
		log.info("entered into user service otpGenerator method");
		
		List<User> user = userIRepo.findByEmail(email);
		log.debug("user data" + user.toString());
		
		if(!user.isEmpty()) {
			User us = user.get(0);

			if(us.getVerified()) {
				
				log.warn("Verification already done exception with email id : " + us.getEmail());
				log.error("before throwing VerificationAlreadyDoneException");
				throw new  VerificationAlreadyDoneException("verification has already done. : " + email);
			}else {
				int otp = og.sixDigitOtp();

				//				us.setOtp(otp);
				//				userIRepo.save(us);

				userIRepo.updateOtp(otp, email);

				eu.sendMail(email, "OTP Regenerated – Complete Your Verification", emailTemplate.getMailBodyOtpRegenerated(us.getGender(), us.getName(), otp, email));
				return "OTP sent via registered email";		
			}

		}else {
			
			log.warn("User not found exception with email id : " + email);
			log.error("before throwing UserNotFoundException");
			throw new UserNotFoundException("User Not found belongs to : " + email);
		}
	}


	public String updatePassword(PasswordDto passwordDto) {
		log.info("entered into user service updatePassword method");
		
		User ut = userIRepo.findById(passwordDto.getId()).get();
		log.debug("user data" + ut.toString());

		if((ut.getPassword()).equals(passwordDto.getOldPassword())) {
			userIRepo.updatePassword(passwordDto.getNewPassword(), ut.getId());
			return "Password updated";
		}else {
			
			log.warn("Old password not matched Exception");
			log.error("before throwing OldPasswordNotMatchedException");
			throw new OldPasswordNotMatchedException("Old password not matched");
		}

	}
}
