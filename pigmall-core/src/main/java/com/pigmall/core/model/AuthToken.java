package com.pigmall.core.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthToken {
	private String accessToken;
	private String jwtToken;
	private String refreshToken;
}
