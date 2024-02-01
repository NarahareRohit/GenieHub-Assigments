package com.app.dto;

import lombok.Data;

@Data	
public class JwtAuthRequest {

	private String useername;
	private String password;
}
