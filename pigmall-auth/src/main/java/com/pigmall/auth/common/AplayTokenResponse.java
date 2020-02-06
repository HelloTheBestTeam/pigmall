package com.pigmall.auth.common;

import com.pigmall.core.common.BaseResponse;
import com.pigmall.core.model.AuthToken;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AplayTokenResponse extends BaseResponse {
	
	public AplayTokenResponse(int code, boolean success) {
		super(code, success);
	}
	
	private String msg;
	private AuthToken authToken;
}
