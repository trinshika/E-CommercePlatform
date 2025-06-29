package com.management.app.mapper;

import org.springframework.stereotype.Component;

import com.management.app.dto.UserInDto;
import com.management.app.dto.UserOutDto;
import com.management.app.model.User;

@Component
public class UserMapper {
	
//	UserInDto -> User
	
	public User UserInDtoToUserEntity(UserInDto userInDto){
		return new User(userInDto.getId(), 
				userInDto.getName(), 
				userInDto.getEmail(), 
				userInDto.getPassword(), 
				userInDto.getRole(),
				userInDto.getGender(),
				11, 
				false);
	}
	
	
	
	
//	user -> UserOutDto
	public UserOutDto UserToUserOutDto(User user){
		return new UserOutDto();
	}
	
}
