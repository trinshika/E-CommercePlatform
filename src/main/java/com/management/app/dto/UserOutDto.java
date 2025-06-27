package com.management.app.dto;

import lombok.Data;

@Data
public class UserOutDto {
	private Long id;
	
	private String name;

	private String email;
	
	private String role;
	
	private String gender;
	
	private boolean verified;
}
