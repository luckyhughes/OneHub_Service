package com.onetesthub.dao;

import java.util.List;

import com.onetesthub.model.User;

public interface UserDao {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);

	public List<User> findUserByUsername(String username);

}