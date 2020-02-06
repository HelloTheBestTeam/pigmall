package com.pigmall.core.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseResponse {
	
	int code;
	boolean success;
	
	public BaseResponse(int code, boolean success) {
		this.code = code;
		this.success = success;
	}
}
