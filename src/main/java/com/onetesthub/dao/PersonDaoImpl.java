package com.onetesthub.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onetesthub.model.Person;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addPerson(Person person) {
		sessionFactory.getCurrentSession().persist(person);
		
	}

	@Override
	public List<Person> listPerson() {
		
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}

	@Override
	public void removePerson(Integer id) {
		
		Person person = (Person) sessionFactory.getCurrentSession().load(Person.class, id);
		
		if(person!=null){
		sessionFactory.getCurrentSession().delete(id);
		}
		
	}

}
