package com.management.app.dto;

import lombok.Data;

@Data
public class UserInDto {
	
	private Long id;
	
	private String name;

	private String email;
	
	private String password;
	
	private String role;

}
