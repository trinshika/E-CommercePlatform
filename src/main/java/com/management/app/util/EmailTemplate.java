package com.management.app.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailTemplate {

	@Value("${app.baseurl}")
	private String baseurl;

	private String getTitleAndName(String gender, String name) {
		return gender.equalsIgnoreCase("male") ? "Mr. " : "Mrs. " + name;
	}

	public String getMailBodyAccountCreation(String gender, String name, int otp, String email) {

		String verificationLink = baseurl + "/user/verification/" + email + "/" + otp;
		System.out.println(verificationLink);
		return "<!DOCTYPE html>"
		+ "<html>"
		+ "<head>"
		+ "<style>"
		+ "  body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
		+ "  .container { max-width: 600px; margin: 40px auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); }"
		+ "  .header { font-size: 24px; font-weight: bold; color: #333333; }"
		+ "  .content { font-size: 16px; color: #555555; line-height: 1.6; margin-top: 20px; }"
		+ "  .otp { font-size: 20px; color: #000000; font-weight: bold; background-color: #f0f0f0; display: inline-block; padding: 10px 20px; margin-top: 10px; border-radius: 5px; }"
		+ "  .button { display: inline-block; margin-top: 20px; padding: 12px 24px; background-color: #28a745; color: white; text-decoration: none; font-weight: bold; border-radius: 5px; }"
		+ "  .footer { margin-top: 30px; font-size: 14px; color: #999999; }"
		+ "</style>"
		+ "</head>"
		+ "<body>"
		+ "<div class='container'>"
		+ "  <div class='header'>Dear " + getTitleAndName(gender, name) + ",</div>"
		+ "  <div class='content'>"
		+ "    <p>Your account has been created successfully.</p>"
		+ "    <p>To verify your account, please use the following OTP:</p>"
		+ "    <div class='otp'>" + otp + "</div>"
		+ "    <p>Or click the button below to verify directly:</p>"
		+ "    <a href='" + verificationLink + "' class='button'>Verify My Account</a>"
		+ "    <p>If you did not initiate this request, please ignore this email.</p>"
		+ "    <p class='footer'>Best regards,<br>Amazon</p>"
		+ "  </div>"
		+ "</div>"
		+ "</body>"
		+ "</html>";
	}


	public String getMailBodySecurityThread(String gender, String name, int otp) {

		return "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<style>"
				+ "  body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
				+ "  .container { max-width: 600px; margin: 40px auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(255, 0, 0, 0.2); }"
				+ "  .header { font-size: 22px; font-weight: bold; color: #d9534f; }"
				+ "  .content { font-size: 16px; color: #333333; line-height: 1.6; margin-top: 20px; }"
				+ "  .warning { font-size: 18px; color: #c9302c; font-weight: bold; background-color: #fbeaea; display: inline-block; padding: 10px 20px; margin-top: 10px; border-left: 5px solid #d9534f; border-radius: 4px; }"
				+ "  .footer { margin-top: 30px; font-size: 14px; color: #999999; }"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<div class='container'>"
				+ "  <div class='header'>Security Alert</div>"
				+ "  <div class='content'>"
				+ "    <p>Dear " + getTitleAndName(gender, name) +",</p>"
				+ "    <p>We noticed an attempt to verify your account from an unrecognized source.</p>"
				+ "    <div class='warning'>If this was not you, please secure your account immediately.</div>"
				+ "    <p>For your safety, do not share your OTP or password with anyone.</p>"
				+ "    <p>If you recognize this activity, no action is needed.</p>"
				+ "    <p class='footer'>Best regards,<br>Amazon Security Team</p>"
				+ "  </div>"
				+ "</div>"
				+ "</body>"
				+ "</html>";
	}

	public String getMailBodyVerificationSuccess(String gender, String name) {

		return "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<style>"
				+ "  body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
				+ "  .container { max-width: 600px; margin: 40px auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0, 128, 0, 0.2); }"
				+ "  .header { font-size: 22px; font-weight: bold; color: #28a745; }"
				+ "  .content { font-size: 16px; color: #333333; line-height: 1.6; margin-top: 20px; }"
				+ "  .success { font-size: 18px; color: #155724; font-weight: bold; background-color: #d4edda; display: inline-block; padding: 10px 20px; margin-top: 10px; border-left: 5px solid #28a745; border-radius: 4px; }"
				+ "  .footer { margin-top: 30px; font-size: 14px; color: #999999; }"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<div class='container'>"
				+ "  <div class='header'>Verification Successful</div>"
				+ "  <div class='content'>"
				+ "    <p>Dear " + getTitleAndName(gender, name) + ",</p>"
				+ "    <p>We are pleased to inform you that your account has been successfully verified.</p>"
				+ "    <div class='success'>Your account is now active and ready to use.</div>"
				+ "    <p>Thank you for verifying your details. You can now enjoy all our features and services.</p>"
				+ "    <p class='footer'>Best regards,<br>Amazon Team</p>"
				+ "  </div>"
				+ "</div>"
				+ "</body>"
				+ "</html>";

	}
	
	public String getMailBodyOtpRegenerated(String gender, String name, int otp, String email) {

	    String verificationLink =  baseurl + "/user/verification/" + email + "/" + otp;

	    return "<!DOCTYPE html>"
	        + "<html>"
	        + "<head>"
	        + "<style>"
	        + "  body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
	        + "  .container { max-width: 600px; margin: 40px auto; background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); }"
	        + "  .header { font-size: 24px; font-weight: bold; color: #333333; }"
	        + "  .content { font-size: 16px; color: #555555; line-height: 1.6; margin-top: 20px; }"
	        + "  .otp { font-size: 20px; color: #000000; font-weight: bold; background-color: #fff3cd; display: inline-block; padding: 10px 20px; margin-top: 10px; border-radius: 5px; border-left: 5px solid #ffc107; }"
	        + "  .button { display: inline-block; margin-top: 20px; padding: 12px 24px; background-color: #007bff; color: white; text-decoration: none; font-weight: bold; border-radius: 5px; }"
	        + "  .footer { margin-top: 30px; font-size: 14px; color: #999999; }"
	        + "</style>"
	        + "</head>"
	        + "<body>"
	        + "<div class='container'>"
	        + "  <div class='header'>OTP Regenerated</div>"
	        + "  <div class='content'>"
	        + "    <p>Dear " +  getTitleAndName(gender, name) + ",</p>"
	        + "    <p>A new OTP has been generated for your account verification as per your request.</p>"
	        + "    <p>Please use the following OTP to complete your verification:</p>"
	        + "    <div class='otp'>" + otp + "</div>"
	        + "    <p>Or you can click the button below to verify your account directly:</p>"
	        + "    <a href='" + verificationLink + "' class='button'>Verify My Account</a>"
	        + "    <p>If you did not request this OTP, please ignore this email or contact our support team immediately.</p>"
	        + "    <p class='footer'>Best regards,<br>Amazon Team</p>"
	        + "  </div>"
	        + "</div>"
	        + "</body>"
	        + "</html>";
	}


}
