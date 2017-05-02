package com.eximius.api.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eximius.api.models.User_Model;
import com.eximius.api.services.UserService;

@RestController
@RequestMapping("/User_details")
public class User_Controller {

	
	@Autowired
	UserService userservices;
	
	@RequestMapping(value="/users", method=RequestMethod.GET,headers="Accept=application/json")
	public List<User_Model> getAllUsers(){
		List<User_Model> users=userservices.getAllUsers();
		
		return users;
	}

	@RequestMapping(value="/users/{contact_no}",method=RequestMethod.GET,headers="Accept=application/json")
	public User_Model getUserById(@PathVariable long contact_no){
		
		User_Model user=userservices.getUserByContact(contact_no);
		return user;
	}
	
	@RequestMapping(value="/users/delete/{conatct_no}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public void  deleteUserById(@PathVariable long contact_no){
		
		userservices.deleteUserByContact(contact_no);
		
	}
	
	
	//@RequestMapping(value="/add/",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	@POST
	@RequestMapping("/users/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
		public User_Model insertUser(@RequestBody User_Model user){
		System.out.println("hello");
		 return userservices.addUser(user);
	
		}
		
		@PUT
		@RequestMapping("/users/update/{contact_no}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public User_Model updateUser(@PathVariable long contact_no,@RequestBody User_Model um){
			um.setUserContactNumber(contact_no);
			return userservices.updateUserByContact(um);
		}
}

