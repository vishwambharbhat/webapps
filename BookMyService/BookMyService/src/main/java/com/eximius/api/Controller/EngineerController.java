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

import com.eximius.api.models.EnginnerModel;
import com.eximius.api.services.EngineerService;


@RestController
@RequestMapping("/Engineer_details")
public class EngineerController {
	@Autowired
	EngineerService enggservices;
	
	@RequestMapping(value="/enggs", method=RequestMethod.GET,headers="Accept=application/json")
	public List<EnginnerModel> getAllEngineers(){
		List<EnginnerModel> users=enggservices.getAllEngineers();
		
		return users;
	}

	@RequestMapping(value="/enggs/{contact_no}",method=RequestMethod.GET,headers="Accept=application/json")
	public EnginnerModel getEngineerById(@PathVariable long contact_no){
		
		EnginnerModel user=enggservices.getEngineerByContact(contact_no);
		return user;
	}
	
	@RequestMapping(value="/enggs/delete/{conatct_no}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public void  deleteEngineerById(@PathVariable long contact_no){
		
		enggservices.deleteEngineerByContact(contact_no);
		
	}
	
	
	//@RequestMapping(value="/add/",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	@POST
	@RequestMapping("/enggs/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
		public EnginnerModel insertEngineerr(@RequestBody EnginnerModel user){
		System.out.println("hello");
		 return enggservices.addEngineer(user);
	
		}
		
		@PUT
		@RequestMapping("/enggs/update/{contact_no}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public EnginnerModel updateEngineer(@PathVariable long contact_no,@RequestBody EnginnerModel um){
			um.setEnggContactNumber(contact_no);
			return enggservices.updateEngineerByContact(um);
		}
}
