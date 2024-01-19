package com.Restaurant_project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant_project.dtos.SignRequest;
import com.Restaurant_project.dtos.UserDto;
import com.Restaurant_project.services.auth.AuthService;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
private final AuthService authService;

public AuthController(AuthService authService) {
this.authService =authService;
}

@PostMapping("/signup")
public ResponseEntity<?> signupUser(@RequestBody SignRequest signRequest) {
	UserDto createdUserDto=authService.createUser(signRequest);
	if (createdUserDto== null)
	{
		return new ResponseEntity<>("user not created. come again later",HttpStatus.BAD_REQUEST);
		
	}
	return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
}
