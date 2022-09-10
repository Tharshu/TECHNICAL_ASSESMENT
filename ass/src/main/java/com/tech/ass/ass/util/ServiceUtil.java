package com.tech.ass.ass.util;

import org.springframework.stereotype.Service;

import com.tech.ass.ass.dto.ResponseDto;

@Service
public class ServiceUtil {

	public ResponseDto getExceptionServiceResponse(Exception e) {
		ResponseDto serviceResponseDto;
		serviceResponseDto = new ResponseDto();
		serviceResponseDto.setStatus(Boolean.FALSE);
		serviceResponseDto.setResponseDto(e.getMessage());
		serviceResponseDto.setErrorDescription(e.getMessage());
		return serviceResponseDto;
	}

	public ResponseDto getServiceResponse(Object responseObject) {
		ResponseDto serviceResponceDto;
		serviceResponceDto = new ResponseDto();
		serviceResponceDto.setStatus(Boolean.TRUE);
		serviceResponceDto.setResponseDto(responseObject);
		return serviceResponceDto;
	}

	public ResponseDto getErrorServiceResponse(Object responseObject) {
		ResponseDto serviceResponceDto;
		serviceResponceDto = new ResponseDto();
		serviceResponceDto.setStatus(Boolean.FALSE);
		serviceResponceDto.setResponseDto(responseObject);
		return serviceResponceDto;
	}

	public ResponseDto getErrorServiceResponse() {
		ResponseDto serviceResponseDto = new ResponseDto();
		serviceResponseDto.setStatus(Boolean.FALSE);
		serviceResponseDto.setErrorCode(Integer.parseInt("0000"));
		serviceResponseDto.setErrorDescription("Error!!!!!!!");
		return serviceResponseDto;
	}


	public ResponseDto getExceptionServiceResponseByProperties() {
		ResponseDto serviceResponseDto;
		serviceResponseDto = new ResponseDto();
		serviceResponseDto.setStatus(Boolean.FALSE);
		serviceResponseDto.setErrorCode(Integer.parseInt("11111"));
		serviceResponseDto.setErrorDescription("Exception ..........");
		return serviceResponseDto;
	}
}
