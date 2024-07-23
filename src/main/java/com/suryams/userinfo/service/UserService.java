package com.suryams.userinfo.service;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.suryams.userinfo.dto.UserDTO;
import com.suryams.userinfo.entity.User;
import com.suryams.userinfo.mapper.UserMapper;
import com.suryams.userinfo.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public UserDTO saveUser(UserDTO userDTO) {
		User user = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return UserMapper.INSTANCE.mapUserToUserDTO(user);
	}

	public List<UserDTO> fetchAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOs = users.stream().map(user->UserMapper.INSTANCE.mapUserToUserDTO(user)).toList();
		return userDTOs;
	}
	
	public ResponseEntity<UserDTO> fetchUserById(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND); 
	}

}
