package com.viraj.dao;

import java.util.List;

public interface UserDao {
	public void addUser(User user);

	public void editUser(User user);

	public void deleteUser(int id);

	public User getUser(int id);

	public List<User> getAllUsers();
}
