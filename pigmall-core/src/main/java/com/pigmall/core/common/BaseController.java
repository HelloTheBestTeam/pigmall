package com.pigmall.core.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	
	public HttpServletRequest request;
	public HttpServletResponse response;
	
	@ModelAttribute
	public void postConstr(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
}
