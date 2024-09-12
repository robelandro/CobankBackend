package com.bank.cobank.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.cobank.utils.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {
	
	@PostMapping("/login")
	public ApiResponse<String> login(@RequestBody String entity) {		
        return new ApiResponse<>("success", "Request was successful", entity);
	}

	@PostMapping("/register")
	public ApiResponse<String> register(@RequestBody String entity) {		
        return new ApiResponse<>("success", "Request was successful", entity);
	}
	
}
