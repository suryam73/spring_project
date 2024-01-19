package com.Restaurant_project.services.auth;

import com.Restaurant_project.dtos.SignRequest;
import com.Restaurant_project.dtos.UserDto;

public interface AuthService {

	UserDto createUser(SignRequest signRequest);

}
