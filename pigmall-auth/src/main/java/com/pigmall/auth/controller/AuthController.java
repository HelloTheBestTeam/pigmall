package com.pigmall.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pigmall.auth.common.AplayTokenResponse;
import com.pigmall.auth.service.AuthService;
import com.pigmall.core.common.BaseController;

/**
 * 认证服务
 * @author chrilwe
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {
	
	@Autowired
	private AuthService authService;
	
	
	/**
	 * 申请令牌
	 */
	@PostMapping("/aplay_token")
	public AplayTokenResponse aplayToken(@RequestBody String username, @RequestBody String password) {
		
		return null;
	}
}
