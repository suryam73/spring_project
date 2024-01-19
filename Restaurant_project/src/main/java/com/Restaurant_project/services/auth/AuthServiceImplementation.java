package com.Restaurant_project.services.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Restaurant_project.Entities.User;
import com.Restaurant_project.dtos.SignRequest;
import com.Restaurant_project.dtos.UserDto;
import com.Restaurant_project.enums.UserRole;
import com.Restaurant_project.repositories.UserRepository;

@Service
public class AuthServiceImplementation  implements AuthService{
private final UserRepository userRepository;


public AuthServiceImplementation(UserRepository userRepository )
{
this.userRepository =userRepository;

}


@Override
public UserDto createUser(SignRequest signRequest) {
	User user=new User();
	user.setName(signRequest.getName());
	user.setEmail(signRequest.getEmail());
	user.setPassword(new BCryptPasswordEncoder().encode(signRequest.getPassword()));
	user.setUserRole(UserRole.CUSTOMER);
	User createUser =userRepository.save(user);
	UserDto createUserDto=new UserDto();
	createUserDto.setId(createUser.getId());
	createUserDto.setName(createUser.getName());
	createUserDto.setEmail(createUser.getEmail());
	createUserDto.setUserRole(createUserDto.getUserRole());
	return createUserDto;
}
	
}
