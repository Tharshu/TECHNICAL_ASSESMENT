package com.tech.ass.ass.controllerTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tech.ass.ass.AssApplicationTests;
import com.tech.ass.ass.dto.JwtRequest;
import com.tech.ass.ass.dto.JwtResponse;
import com.tech.ass.ass.web.v1.controller.JwtController;

@Transactional
public class JwtControllerTest extends AssApplicationTests{

	@Autowired
	JwtController jwtController;
	
	JwtRequest jwtRequest = null;
	
	@Before
	public void setUp() throws Exception {
		jwtRequest = new JwtRequest();
		jwtRequest.setUserName("remit@code.com");
		jwtRequest.setUserPassword("Test_1user");
	}
	
	@Test
	public void createJwtToken() throws Exception {
		JwtResponse jwt = jwtController.createJwtToken(jwtRequest);
		Assert.assertNotNull("NULL failure", jwt.getJwtToken());
//		Assert.assertNull("Not NULL failure", jwt.);
	}
	
	
}
