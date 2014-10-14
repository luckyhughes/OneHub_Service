package com.onetesthub.service;

import java.util.List;

import com.onetesthub.model.Person;

public interface PersonService {
	
	public void addPerson(Person person);
    public List<Person> listPerson();
    public void removePerson(Integer id);

}
