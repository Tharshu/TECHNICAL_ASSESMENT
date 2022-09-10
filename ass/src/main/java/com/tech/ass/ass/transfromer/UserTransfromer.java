package com.tech.ass.ass.transfromer;

import org.springframework.stereotype.Component;

import com.tech.ass.ass.domain.User;
import com.tech.ass.ass.dto.UserDto;

@Component
public class UserTransfromer implements BaseTransformer<User, UserDto>{

	@Override
	public UserDto transform(User user) {
		// TODO Auto-generated method stub
		if (user != null) {
			UserDto userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setName(user.getName());
			userDto.setMobile(user.getMobile());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			return userDto;
		} else {
		return null;
		}
	}

	@Override
	public User reverseTransform(UserDto userDto) {
		// TODO Auto-generated method stub
		if (userDto != null) {
			
			User user = new User();
			user.setUserId(userDto.getUserId());
			user.setName(userDto.getName());
			user.setMobile(userDto.getMobile());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
			return user;
		} else {
		return null;
		}
	}

}
