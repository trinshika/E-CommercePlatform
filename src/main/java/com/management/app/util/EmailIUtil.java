package com.management.app.util;

public interface EmailIUtil {

	public void sendMail(String to, String[] cc, String[] bcc, String subject, String text);
	public void sendMail(String to, String subject, String text);
	public void sendMail(String to, String[] cc, String subject, String text);
	public void sendMail( String[] bcc, String to, String subject, String text);
}
