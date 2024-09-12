package com.bank.cobank.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.cobank.utils.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    @GetMapping("/getMethodName")
    public ApiResponse<String> getMethodName() {
        return new ApiResponse<>("success", "Request was successful I guess");
    }
	
}
