package com.tech.ass.ass.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4537231921058016998L;
//	private final UserDto user;
    private final String jwtToken;

}
