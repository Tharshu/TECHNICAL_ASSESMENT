package com.tech.ass.ass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tech.ass.ass.transfromer.*;
import com.tech.ass.ass.dao.BaseDao;
import com.tech.ass.ass.dao.UserDao;
//import com.tech.ass.ass.dao.UserRepository;
import com.tech.ass.ass.daoImpl.UserDaoImpl;
import com.tech.ass.ass.domain.User;
import com.tech.ass.ass.dto.JwtRequest;
import com.tech.ass.ass.dto.JwtResponse;
import com.tech.ass.ass.dto.UserDto;
import com.tech.ass.ass.util.JwtUtil;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    BaseDao<User> baseUser;
    
//	@Autowired
//	private UserRepository userRepository;

    @Autowired
    private UserDao userDao;
    
//	@Autowired
//	private UserTransformer userTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
    	log.info("JwtService.createJwtToken() invoked.");
//        String userName = jwtRequest.getUserName();
//        String userPassword = jwtRequest.getUserPassword();
////        authenticate(userName, userPassword);
//
//        UserDetails userDetails = loadUserByUsername(userName);
//        final String newGeneratedToken = jwtUtil.generateToken(userDetails);
//        UserDto user = (UserDto) userDao.findByUserName(userName);
//        
//        return new JwtResponse(user, newGeneratedToken);
    	
    	 try {
             authenticationManager.authenticate(
                     new UsernamePasswordAuthenticationToken(
                             jwtRequest.getUserName(),
                             jwtRequest.getUserPassword()
                     )
             );
         } catch (BadCredentialsException e) {
             throw new Exception("INVALID_CREDENTIALS", e);
         }

         final UserDetails userDetails
                 = loadUserByUsername(jwtRequest.getUserName());

         final String token =
        		 jwtUtil.generateToken(userDetails);

         return  new JwtResponse(token);
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDao.findByUserName(username);
    	
    	return (UserDetails) new org.springframework.security.core.userdetails.User(userDto.getEmail(),userDto.getPassword(),new ArrayList<>());
    	
//        User user = baseUser.readName(username);
//        log.info("userDto = {}",userDto);
//
//        if (user != null) {
//            return new org.springframework.security.core.userdetails.User(
//                    user.getEmail(),
//                    user.getPassword(), null
//            );
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
        
    }
    

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
