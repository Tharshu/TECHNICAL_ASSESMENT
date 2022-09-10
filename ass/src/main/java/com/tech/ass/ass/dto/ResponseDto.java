package com.tech.ass.ass.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7363683862749269735L;
	private boolean status = true;
	private int errorCode;
	private String errorDescription;
	private Object responseDto;



}