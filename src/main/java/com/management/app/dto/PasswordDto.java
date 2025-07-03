package com.management.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasswordDto {

	private Long id;
	
	@NotBlank(message = "old password is required")
	private String oldPassword;
	
	@NotBlank(message = "new password is required")
	private String newPassword;
}
