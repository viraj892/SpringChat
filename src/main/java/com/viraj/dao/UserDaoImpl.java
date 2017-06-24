package com.viraj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Viraj Shah
 *
 *         ORM access endpoints
 */
@Repository
class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;

	/**
	 * Adds a user to the database on registration
	 * 
	 * @param user
	 *            User object to be persisted to the database
	 */
	@Override
	@Transactional
	public void addUser(User user) {
		Session s = session.getCurrentSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
	}

	/**
	 * Updates a user in the database
	 * 
	 * @param user
	 *            new User object to be updated in the database
	 */
	@Override
	public void editUser(User user) {
		Session s = session.getCurrentSession();
		s.beginTransaction();
		s.update(user);
		s.getTransaction().commit();
	}

	/**
	 * Adds a user to the database on registration
	 * 
	 * @param id
	 *            int type value id of the user to be deleted from the database
	 */
	@Override
	public void deleteUser(int id) {
		Session s = session.getCurrentSession();
		s.beginTransaction();
		s.delete(id);
		s.getTransaction().commit();
	}

	/**
	 * 
	 * Retrieve specific user from the database
	 * 
	 * @param id
	 *            int type value id of the user to be retrieved from the
	 *            database
	 */
	@Override
	public User getUser(int id) {
		return (User) session.getCurrentSession().get(User.class, id);
	}

	/**
	 * Retrieves all the users from database
	 * 
	 * @return List of type User
	 */
	@Override
	public List<User> getAllUsers() {
		Session s = session.getCurrentSession();
		s.beginTransaction();
		return s.createQuery("select g from user g").list();
	}

}
