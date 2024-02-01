package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequest;
import com.app.dto.userDto;
import com.app.entity.User;
import com.app.servies.userService;


@RestController
@RequestMapping
public class HomeController {
	
	@Autowired
	private userService userservice;
	
	@GetMapping("/allUser")
	public List<User> getAlluser(){
		return userservice.getAll();
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signUp(@RequestBody userDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.registerNewUser(dto));
// {
//	    "name":"Rohit",
//	    "userName":"Rohit",
//	    "email":"rohit",
//	    "password":"rohit123"
// }
	}
	
	@GetMapping("/login")
	public User logIn(@RequestBody LoginRequest loginReq) {
		String username = loginReq.getUserName();
		String password = loginReq.getPassword();
		User user =  userservice.logIn(username, password);
		return user;
		
//{
//"userName":"Rohit",
//"password":"rohit123"
//}
	}
	
	@DeleteMapping("/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable long uid){
		userservice.removeUser(uid);
		return ResponseEntity.ok(Map.of("meg","user deleted Successfully"));
	}
	
	
	
	
	
}
