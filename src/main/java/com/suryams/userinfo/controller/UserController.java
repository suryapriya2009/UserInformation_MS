package com.suryams.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suryams.userinfo.dto.UserDTO;
import com.suryams.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
		UserDTO userDTOreturn = userService.saveUser(userDTO);
		return new ResponseEntity<>(userDTOreturn, HttpStatus.OK);

	}

	@GetMapping("/fetchAllUser")
	public ResponseEntity<List<UserDTO>> fetchAllUser() {
		List<UserDTO> userDTOList = userService.fetchAllUsers();
		return new ResponseEntity<List<UserDTO>>(userDTOList, HttpStatus.OK);

	}

	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer userId) {
		return userService.fetchUserById(userId);

	}

}
