package com.tech.ass.ass.dao;

import java.util.List;

import com.tech.ass.ass.domain.User;
import com.tech.ass.ass.dto.UserDto;

public interface UserDao extends BaseDao<User> {

	UserDto registerNewUser(UserDto user);

	UserDto findByUserName(String userName);

	List<UserDto> getAllUsers();
	
}
