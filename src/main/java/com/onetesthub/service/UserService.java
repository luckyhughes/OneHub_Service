package com.onetesthub.service;

import java.util.List;

import com.onetesthub.model.Person;
import com.onetesthub.model.User;

public interface  UserService {
	
	public void addUser(User person);
    public List<User> listUser();
    public void removeUser(Integer id);
    public User findUserByUsername(String username);

}
