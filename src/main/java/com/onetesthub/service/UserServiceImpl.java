package com.onetesthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetesthub.dao.PersonDao;
import com.onetesthub.dao.UserDao;
import com.onetesthub.model.User;
import com.onetesthub.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	@Transactional
	public List<User> listUser() {
		
		return userDao.listUser();
	}

	@Override
	@Transactional
	public void removeUser(Integer id) {
		userDao.removeUser(id);
		
	}

	@Override
	@Transactional
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
	

}
