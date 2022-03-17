package com.vinhnq.dao;



import com.vinhnq.entity.User;

import java.util.List;

public interface UserDAO {
	/**
	 * @param username
	 * @return
	 */
	public User loadUserByUsername(String username);

	/**
	 * getAllUsers
	 * @return List<User>
	 */
	List<User> getAllUsers();

	/**
	 * @param user
	 * @return
	 */
	public boolean installUser(User user);

	/**
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
}
