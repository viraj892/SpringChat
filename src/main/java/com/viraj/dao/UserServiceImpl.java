package com.viraj.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	private UserDetails userDetails;

	@Transactional
	public void addUser(User user) {
//		System.out.println(user.toString());
		userdao.addUser(user);
	}

	@Transactional
	public void editUser(User user) {
		userdao.editUser(user);
	}

	@Transactional
	public void deleteUser(int id) {
		userdao.deleteUser(id);
	}

	@Transactional
	public User getUser(int id) {
		return userdao.getUser(id);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
