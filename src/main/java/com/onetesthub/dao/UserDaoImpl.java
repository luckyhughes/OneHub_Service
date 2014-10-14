package com.onetesthub.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onetesthub.model.Person;
import com.onetesthub.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
		
	}

	@Override
	public List<User> listUser() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	@Override
	public List<User> listUserByUsername(String username) {
		
		return sessionFactory.getCurrentSession().createQuery("from User where user.username =username").list();
	}

	@Override
	public void removeUser(Integer id) {
		
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		
		if(user!=null){
		sessionFactory.getCurrentSession().delete(id);
		}
		
	}

}
