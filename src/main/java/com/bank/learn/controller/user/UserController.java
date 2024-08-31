package com.bank.learn.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.learn.utils.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    @GetMapping("/getMethodName")
    public ApiResponse<String> getMethodName() {
        String message = "Hello, this is my first API using Spring Boot";
        return new ApiResponse<>("success", "Request was successful", message);
    }
	
}
