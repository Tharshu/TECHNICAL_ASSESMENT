package com.tech.ass.ass.service.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.ass.ass.dao.UserDao;
import com.tech.ass.ass.domain.User;
import com.tech.ass.ass.dto.UserDto;
import com.tech.ass.ass.transfromer.UserTransfromer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceBL {
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
	UserTransfromer userTransfromer;
    
    @Autowired
    UserDao userDao;
	
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    
	public UserDto registerNewUser(UserDto user) {
		log.info("UserServiceBL.registerNewUser() invoked.");
		user.setPassword(getEncodedPassword(user.getPassword()));
	        return userDao.registerNewUser(user);
	}

	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		log.info("UserServiceBL.getAllUsers() invoked.");
		return userDao.getAllUsers();
	}
	
	

}
