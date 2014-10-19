package com.onetesthub.dao;

import java.util.List;

import com.onetesthub.model.User;

public interface UserDao {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);

	public User findUserByUsername(String username);

}