package com.viraj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viraj.dao.User;
import com.viraj.dao.UserService;

@RestController
public class ListAllUsers {

	@Autowired
	UserService service;

	/**
	 * Restful Service that returns entire User table from the database
	 * 
	 * @return List of type User containing all the users and their credentials
	 *         in the database
	 */
	@RequestMapping(value = "/list-users", method = RequestMethod.POST)
	public List<User> showAllUsers() {
		List<User> allUsers = service.getAllUsers();
		String list = "";
		for (User user : allUsers) {
			list.concat(user.getUsername() + "\n");
		}
		return allUsers;
	}

}
