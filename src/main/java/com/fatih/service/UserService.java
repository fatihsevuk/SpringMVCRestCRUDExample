package com.fatih.service;

import java.util.List;

import com.fatih.model.User;

public interface UserService {

	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);
	
	List<User> findAllUser();
	
	void deleteAllUser();
	
	public boolean isUserExist(User user);
	
	
	
}
