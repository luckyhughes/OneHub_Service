package com.onetesthub.service;

import java.util.List;

import com.onetesthub.model.Person;
import com.onetesthub.model.User;

public interface  UserService {
	
	public void addUser(User person);
    public List<User> listUser();
    public void removeUser(Integer id);
    public List<User> findUserByUsername(String username);

}
