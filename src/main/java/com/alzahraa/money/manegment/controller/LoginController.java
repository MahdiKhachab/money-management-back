package com.alzahraa.money.manegment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzahraa.money.manegment.dto.LoginRequest;
import com.alzahraa.money.manegment.dto.LoginResponse;
import com.alzahraa.money.manegment.dto.RegisterRequest;
import com.alzahraa.money.manegment.service.impl.AuthService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		String token = authService.login(request);
		return new LoginResponse(token);
	}

	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request) {
		authService.register(request);
		return "User registered successfully";
	}
}