package com.management.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtilImpl implements EmailIUtil {

	@Autowired
	private JavaMailSender sender;

	public void sendMail(String to, String[] cc, String[] bcc, String subject, String text) {

		MimeMessage message = sender.createMimeMessage();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setBcc(bcc);
			helper.setSubject(subject);
			helper.setText(text , true);
			sendMail(message);

		} catch (Exception e) {

		}
	}



	public void sendMail(String to, String subject, String text) {

		MimeMessage message = sender.createMimeMessage();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text , true);
			sendMail(message);

		} catch (Exception e) {

		}
	}	


	public void sendMail(String to, String[] cc, String subject, String text) {

		MimeMessage message = sender.createMimeMessage();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(text , true);
			sendMail(message);

		} catch (Exception e) {

		}
	}


	public void sendMail( String[] bcc, String to, String subject, String text) {

		MimeMessage message = sender.createMimeMessage();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setTo(to);
			helper.setBcc(bcc);
			helper.setSubject(subject);
			helper.setText(text , true);
			sendMail(message);

		} catch (Exception e) {

		}
	}	
	
	void sendMail(MimeMessage message) {
		new Thread(() -> {
			sender.send(message);
		}).start();
	}

}
