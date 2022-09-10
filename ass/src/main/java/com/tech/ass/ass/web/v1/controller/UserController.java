package com.tech.ass.ass.web.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ass.ass.domain.User;
import com.tech.ass.ass.dto.JwtRequest;
import com.tech.ass.ass.dto.JwtResponse;
import com.tech.ass.ass.dto.ResponseDto;
import com.tech.ass.ass.dto.UserDto;
import com.tech.ass.ass.service.JwtService;
import com.tech.ass.ass.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/auth")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;

	
    @PostMapping({"/registerNewUser"})
    public ResponseDto registerNewUser(@RequestBody UserDto user) {
    	log.info("UserController.registerNewUser() invoked.");
        return userService.registerNewUser(user);
    }
    
    @GetMapping({"/getAll"})
    public ResponseDto getAllUsers() {
    	log.info("UserController.getAllUsers() invoked.");
    	return userService.getAllUsers();
    }

}
