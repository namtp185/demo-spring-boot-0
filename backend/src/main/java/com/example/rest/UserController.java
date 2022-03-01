package com.example.rest;

import java.io.IOException;

import com.example.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {

	private ObjectMapper objectMapper;

	public UserController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@GetMapping("/users")
	public String getUser(@RequestParam(name = "name") String name, @RequestParam(name = "gender") String gender) {
		return "looking for user with name: " + name + ", gender: " + gender;
	}

	@PostMapping("/users")
<<<<<<< HEAD:backend/src/main/java/com/example/rest/HelloController.java
	public String createUser(@RequestBody User userForm) {
		return "creating user with info, name: " + userForm.getName() + ", age: " + String.valueOf(userForm.getAge()) + "occupation:" + userForm.getOccupation() + "gender: " + userForm.getGender();
=======
	public String createUser(@RequestBody String userJsonString) throws IOException {
		UserDTO user = objectMapper.readerFor(UserDTO.class).readValue(userJsonString);
		return "creating user with info, name: " + user.getName() + ", age: " + String.valueOf(user.getAge()) + ", occupation: " + user.getOccupation() + ", gender: " + user.getGender(); 
>>>>>>> master:backend/src/main/java/com/example/rest/UserController.java
	}

	@GetMapping("/users/{id}")
	@ResponseBody
	public String getUserDetail(@PathVariable String id) {
		return "looking for user with id: " + id;
	}

	@PutMapping(value="/users/{id}")
<<<<<<< HEAD:backend/src/main/java/com/example/rest/HelloController.java
	public String editUser(@PathVariable String id, @RequestBody User userForm) {
		return "editing for user id:" +  id + " with new info, name: " + userForm.getName() + ", age: " + String.valueOf(userForm.getAge()) + "occupation:" + userForm.getOccupation() + "gender: " + userForm.getGender();
=======
	public String editUser(@PathVariable String id, @RequestBody String userJsonString) throws IOException {
		UserDTO user = objectMapper.readerFor(UserDTO.class).readValue(userJsonString);
		return "editing user id: " +  id + " with info, name: " + user.getName() + ", age: " + String.valueOf(user.getAge()) + ", occupation: " + user.getOccupation() + ", gender: " + user.getGender(); 
>>>>>>> master:backend/src/main/java/com/example/rest/UserController.java
	}

	@DeleteMapping(value="/users/{id}")
	public String deleteUser(@PathVariable String id) {
		return "deleting for user id:" +  id;
	}
	// @PostMapping(value="/users")
	// public User createUser(@RequestBody User user) {

	// 	return user;
	// }


}
