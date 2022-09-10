package com.tech.ass.ass.web.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ass.ass.dto.JwtRequest;
import com.tech.ass.ass.dto.JwtResponse;
import com.tech.ass.ass.service.JwtService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/v1/jwt")
public class JwtController {
	
	@Autowired
	JwtService jwtService;

	@PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		log.info("JwtController.createJwtToken() invoked.");
        return jwtService.createJwtToken(jwtRequest);
    }
}
