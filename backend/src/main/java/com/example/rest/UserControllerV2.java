package com.example.rest;

import com.example.rest.request.UserRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping(value = "/v2/users")
public class UserControllerV2 {

	@PostMapping()
	public void createUser(@Valid @RequestBody UserRequest userRequest) {
		log.info("post with user info {}", userRequest);
	}

	@GetMapping("/{id}")
	public void getUser(@PathVariable int id) {
		log.info("get users with id {}", id);
	}

	@GetMapping()
	public void searchUser(@RequestParam(name = "name") String name, @RequestParam(name = "gender") String gender) {
		log.info("get users with param: name: {}, gender: {}", name, gender);
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
