package com.onetesthub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onetesthub.model.User;
import com.onetesthub.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listContacts() {
			
		return userService.listUser();

	}
	
	@RequestMapping(value = "/user/list/{username}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findUserByUsername(@PathVariable("username") String username) {
			
		return userService.findUserByUsername(username);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {

		userService.addUser(user);
		return new ResponseEntity(HttpStatus.CREATED);

	}

}
