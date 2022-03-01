package com.example.springboot;

import com.example.entity.User;

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
public class HelloController {

	private ModelMapper modelMapper;

	public HelloController(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@GetMapping("/users")
	public String getUser(@RequestParam(name = "name") String name, @RequestParam(name = "gender") String gender) {
		return "looking for user with name: " + name + ", gender: " + gender;
	}

	@PostMapping("/users")
	public String createUser(@RequestBody User userForm) {
		return "creating user with info, name: " + userForm.getName() + ", age: " + String.valueOf(userForm.getAge()) + "occupation:" + userForm.getOccupation() + "gender: " + userForm.getGender(); 
	}

	@GetMapping("/users/{id}")
	@ResponseBody
	public String getUserDetail(@PathVariable String id) {
		return "looking for user with id: " + id;
	}

	@PutMapping(value="/users/{id}")
	public String editUser(@PathVariable String id, @RequestBody User userForm) {
		return "editing for user id:" +  id + " with new info, name: " + userForm.getName() + ", age: " + String.valueOf(userForm.getAge()) + "occupation:" + userForm.getOccupation() + "gender: " + userForm.getGender(); 
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
