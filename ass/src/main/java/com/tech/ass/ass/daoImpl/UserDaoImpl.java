package com.tech.ass.ass.daoImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.ass.ass.dao.UserDao;
import com.tech.ass.ass.domain.User;
import com.tech.ass.ass.dto.UserDto;
import com.tech.ass.ass.transfromer.UserTransfromer;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	@Autowired
	UserTransfromer userTransfromer;
	
	@Transactional
	@Override
	public UserDto registerNewUser(UserDto userDto) {
		// TODO Auto-generated method stub
		log.info("UserDaoImpl.registerNewUser() invoked.");
		User user = userTransfromer.reverseTransform(userDto);
		User saveUser = saveOrUpdate(user);
		return userTransfromer.transform(saveUser);
	}

	@Override
	public UserDto findByUserName(String userName) {
		// TODO Auto-generated method stub
		log.info("UserDaoImpl.findByUserName() invoked.");
		UserDto userDto = null;
		User user = null;
		Criteria criteria = getCurrentSession().createCriteria(User.class,"User");
		criteria.add(Restrictions.eq("User.email", userName));
		user = (User) criteria.uniqueResult();
		if (user != null) {
			userDto = userTransfromer.transform(user);
		}
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		log.info("UserDaoImpl.getAllUsers() invoked.");
		Criteria criteria = getCurrentSession().createCriteria(User.class,"User");
		List<User> users = criteria.list();
		List<UserDto> userDtos = null; 
		if (users != null && !users.isEmpty()) {
			userDtos = users.stream().map(userDto -> {
				return userTransfromer.transform(userDto);
			}).collect(Collectors.toList());
		}
		return userDtos;
	}

}
