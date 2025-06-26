package com.management.app.util;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class OtpGenerator implements OtpIgenerator{
	
	Random random = new Random();
	
	public int threeDigitOtp() {
		return 100 + random.nextInt(900);
	}
	
	public int fourDigitOtp() {
		return 1000 + random.nextInt(9000);
	}
	
	public int fiveDigitOtp() {
		return 10000 + random.nextInt(90000);
	}
	
	public int sixDigitOtp() {
		return 100000 + random.nextInt(900000);
	}
	
	public int sevenDigitOtp() {
		return 1000000 + random.nextInt(9000000);
	}
	
	public int eigthDigitOtp() {
		return 10000000 + random.nextInt(90000000);
	}
	
}
