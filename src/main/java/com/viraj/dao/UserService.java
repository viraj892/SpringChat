package com.viraj.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	public void addUser(User user);

	public void editUser(User user);

	public void deleteUser(int id);

	public User getUser(int id);

	public List<User> getAllUsers();

	public void setUserDetails(UserDetails userDetails);

	public UserDetails getUserDetails();
}
