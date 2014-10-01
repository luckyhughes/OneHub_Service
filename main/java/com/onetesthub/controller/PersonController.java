package com.onetesthub.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onetesthub.model.Person;
import com.onetesthub.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/person/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> listContacts() {

		return personService.listPerson();

	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {

		personService.addPerson(person);
		return new ResponseEntity(HttpStatus.CREATED);

	}

	//
	// @RequestMapping("/delete/{contactId}")
	// public String deleteContact(@PathVariable("contactId")
	// Integer contactId) {
	//
	// contactService.removeContact(contactId);
	//
	// return "redirect:/index";
	// }

	// @RequestMapping("person/{id}")
	// @ResponseBody
	// public Person getById(@PathVariable Long id) {
	// return personService.getById(id);
	// }

	/*
	 * same as above method, but is mapped to
	 * 
	 * /api/person?id= rather than /api/person/{id}
	 */

//	@RequestMapping(value = "person", params = "id")
//	@ResponseBody
//	public Person getByIdFromParam(@RequestParam Long id) {
//		return personService.getById(id);
//
//	}

}
