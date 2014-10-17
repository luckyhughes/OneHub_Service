package com.onetesthub.controller;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.onetesthub.model.Person;
import com.onetesthub.model.User;
import com.onetesthub.service.UserService;

@Controller
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

	//test comment
	@Autowired
	private UserService userService;

	@GET
	@Path("/user/list")
	public Response listUsers() {

		return Response.status(200).entity(userService.listUser()).build();

	}

	@GET
	@Path("/user/list/{username}")
	public Response findUserByUsername(@PathParam("username") String username) {

		return Response.status(200)
				.entity(userService.findUserByUsername(username)).build();

	}

	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {

		userService.addUser(user);
		return Response.status(201).build();

	}

}
