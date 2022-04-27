package com.example.rest;

import java.util.List;

import javax.validation.Valid;

import com.example.application.dto.request.UserRequest;
import com.example.application.service.UserService;
import com.example.domain.User;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/v2/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserControllerV2 {

	UserService userService;

	@PostMapping("/register")
	@ResponseBody
	public User createUser(@Valid @RequestBody UserRequest userRequest) {
		log.info("post with user info {}", userRequest);
		return userService.addUser(userRequest);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public void getUser(@PathVariable int id) {
		log.info("get users with id {}", id);
	}

	// only admin role can access this route
	@GetMapping("/search")
	@ResponseBody
	public List<User> searchUser(@RequestParam(name = "name") String name, @RequestParam(name = "gender") String gender) {
		log.info("Enter route: get users with param: name: {}, gender: {}", name, gender);
		List<User> users = userService.searchUserByGenderAndName(gender, name);
		log.info("Exit route");
		return users;
	}

	// only admin role can access this route
	@GetMapping("/")
	@ResponseBody
	public List<User> getAllUsers() {
		log.info("Enter route: get all users");
		List<User> users = userService.getListUser();
		log.info("Exit route");
		return users;
	}

	@PutMapping("/{id}")
	public void editUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
		log.info("edit user id: {} with info: {}", id, userRequest);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		log.info("delete user with id: {}", id);
	}

}
