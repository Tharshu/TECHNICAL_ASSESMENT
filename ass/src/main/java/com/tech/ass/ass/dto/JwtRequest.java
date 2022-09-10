package com.tech.ass.ass.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequest implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7793055720619484254L;
	private final String userName;
    private final String userPassword;

}
