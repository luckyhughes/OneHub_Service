package com.onetesthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetesthub.dao.PersonDao;
import com.onetesthub.model.Person;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	@Transactional
	public void addPerson(Person person) {
		
		personDao.addPerson(person);

	}
	
	@Override
	@Transactional
	public List<Person> listPerson() {

		return personDao.listPerson();

	}

	@Override
	@Transactional
	public void removePerson(Integer id) {

		personDao.removePerson(id);

	}

}