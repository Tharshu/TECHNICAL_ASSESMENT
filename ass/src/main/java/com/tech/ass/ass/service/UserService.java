package com.tech.ass.ass.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ass.ass.dao.UserDao;
import com.tech.ass.ass.dto.ResponseDto;
import com.tech.ass.ass.dto.UserDto;
import com.tech.ass.ass.service.bl.UserServiceBL;
import com.tech.ass.ass.util.ServiceUtil;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserServiceBL userServiceBL;

	@Autowired
	UserDao userDao;

	@Autowired
	ServiceUtil serviceUtil;

	public ResponseDto registerNewUser(UserDto user) {
		log.info("UserServiceImpl.addUser(UserDto userDto) invoked.");
		ResponseDto responseDto = null;
		UserDto userDto = null;
		try {
			userDto = userDao.findByUserName(user.getEmail());
			if (userDto == null) {
				userDto = new UserDto();
				userDto = userServiceBL.registerNewUser(user);
				
				if (userDto != null) {
					log.info("User details saved.");
					responseDto = serviceUtil.getServiceResponse(userDto);
				} else {
					log.info("Unable to save user details.");
					responseDto = serviceUtil.getErrorServiceResponse();
				}
			} else {
				responseDto = new ResponseDto();
				responseDto.setStatus(false);
				responseDto.setErrorCode(222);
				responseDto.setErrorDescription("Alredy registerd Email");
				return responseDto;
			}

		} catch (Exception e) {
			log.error("Exception occurs while saving user details.", e);
			responseDto = serviceUtil.getExceptionServiceResponseByProperties();
		}

		return responseDto;
	}

	public ResponseDto getAllUsers() {
		log.info("UserServiceImpl.getAllUsers() invoked.");
		ResponseDto responseDto = null;
		try {
			List<UserDto> userDto = userServiceBL.getAllUsers();
			if (userDto != null) {
				log.info("User details are retrieved.");
				responseDto = serviceUtil.getServiceResponse(userDto);
			} else {
				log.info("Unable to retrieved user details.");
				responseDto = serviceUtil.getErrorServiceResponse();
			}

		} catch (Exception e) {
			log.error("Exception occurs while retrieved user details.", e);
			responseDto = serviceUtil.getExceptionServiceResponseByProperties();
		}

		return responseDto;
	}

}
