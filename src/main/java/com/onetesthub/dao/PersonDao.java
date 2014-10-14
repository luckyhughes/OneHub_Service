package com.onetesthub.dao;

import java.util.List;

import com.onetesthub.model.Person;

public interface PersonDao {
	
	public void addPerson(Person person);
    public List<Person> listPerson();
    public void removePerson(Integer id);

}
