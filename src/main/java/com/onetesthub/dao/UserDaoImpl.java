package com.onetesthub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<User> findUserByUsername(String username) {
		
		List<User> users = new ArrayList<User>();
		
		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username).list();
		
		if(users.size()>0) {
			
			return users;
		}
		else{
			
			return null;
		}
	}

	@Override
	public void removeUser(Integer id) {
		
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		
		if(user!=null){
		sessionFactory.getCurrentSession().delete(id);
		}
		
	}

}
