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

import com.eximius.api.models.Service_Model;

import com.eximius.api.services.Service_Service;


@RestController
@RequestMapping("/Service_details")
public class Service_Controller {
	@Autowired
	Service_Service serviceServices;
	
	@RequestMapping(value="/services", method=RequestMethod.GET,headers="Accept=application/json")
	public List<Service_Model> getAllUsers(){
		List<Service_Model> services=serviceServices.getAllServices();
		
		return services;
	}

	@RequestMapping(value="/services/{serv_name}",method=RequestMethod.GET,headers="Accept=application/json")
	public Service_Model getUserById(@PathVariable String serv_name){
		
		Service_Model service=serviceServices.getServiceByName(serv_name);
		return service;
	}
	
	@RequestMapping(value="/services/delete/{serv_name}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public void  deleteUserById(@PathVariable String serv_name){
		
		serviceServices.deleteServiceByName(serv_name);
		
	}
	
	
	//@RequestMapping(value="/add/",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	@POST
	@RequestMapping("/services/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
		public Service_Model insertUser(@RequestBody Service_Model service){
		//System.out.println("hello");
		 return serviceServices.addService(service);
	
		}
		
		@PUT
		@RequestMapping("/services/update/{serv_name}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Service_Model updateUser(@PathVariable String serv_name,@RequestBody Service_Model um){
			um.setServiceName(serv_name);
			return serviceServices.updateServiceByName(um);
		}
}
