package com.onetesthub.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.onetesthub.model.Person;
import com.onetesthub.service.PersonService;

@Controller
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	@GET
	@Path("/person/list")
	public List<Person> listContacts() {

		return personService.listPerson();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/person")
	public Response addPerson(Person person) {
		
		personService.addPerson(person);
		return Response.status(201).entity(person).build();
 
	}
	
//	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
//
//		personService.addPerson(person);
//		return new ResponseEntity(HttpStatus.CREATED);
//
//	}

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
