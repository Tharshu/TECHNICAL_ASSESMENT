package com.tech.ass.ass.controllerTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tech.ass.ass.AssApplicationTests;
import com.tech.ass.ass.dto.ResponseDto;
import com.tech.ass.ass.dto.UserDto;
import com.tech.ass.ass.web.v1.controller.UserController;

@Transactional
public class UserControllerTest extends AssApplicationTests{

	@Autowired
	UserController userController;
	
	UserDto userDto =null;
	
	@Before
	public void setUp() throws Exception {
		userDto = new UserDto();
		userDto.setName("Ker");
		userDto.setEmail("abc@code.com");
		userDto.setMobile("0778465321");
		userDto.setPassword("Test_1user");
	}
	
	@After
	public void tearDown() throws Exception {
		userDto = null;
	}
	
	@Test
	public void registerNewUser() {
		ResponseDto user = userController.registerNewUser(userDto);
		Assert.assertNotNull("NULL failure", user.getResponseDto());
		Assert.assertNull("Not NULL failure", user.getErrorDescription());
	}
	
	@Test
	public void getAllUsers() {
		ResponseDto allUser = userController.getAllUsers();
		Assert.assertNotNull("NULL failure", allUser.getResponseDto());
		Assert.assertNull("Not NULL failure", allUser.getErrorDescription());
	}
	
}
