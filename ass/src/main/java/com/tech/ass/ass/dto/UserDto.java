package com.tech.ass.ass.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4064952557078950348L;
	
	private Long userId;
	private String name;
	private String email;
	private String mobile;
	private String password;
	
}
