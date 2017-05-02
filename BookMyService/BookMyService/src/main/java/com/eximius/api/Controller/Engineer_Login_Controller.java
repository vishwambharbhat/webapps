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

import com.eximius.api.models.Login_Model;
import com.eximius.api.services.Engineer_Login_Service;


@RestController
@RequestMapping("/EnggLogin_details")
public class Engineer_Login_Controller {
	@Autowired
	Engineer_Login_Service loginService;
	
	@RequestMapping(value="/engglogins", method=RequestMethod.GET,headers="Accept=application/json")
	public List<Login_Model> getAllUserLogins(){
		List<Login_Model> logins=loginService.getAllEnggLoginServices();
		
		return logins;
	}

	@RequestMapping(value="/engglogins/{contact_no}",method=RequestMethod.GET,headers="Accept=application/json")
	public Login_Model getUserLoginById(@PathVariable long contact_no){
		
		Login_Model login=loginService.getEnggLoginByContact(contact_no);
		return login;
	}
	
	@RequestMapping(value="/engglogins/delete/{conatct_no}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public void  deleteUserLoginById(@PathVariable long contact_no){
		
		loginService.deleteEnggLoginByContact(contact_no);
		
	}
	
	
	//@RequestMapping(value="/add/",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	@POST
	@RequestMapping("/engglogins/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
		public Login_Model insertUserLogin(@RequestBody Login_Model user){
		System.out.println("hello");
		 return loginService.addLogin(user);
	
		}
		
		@PUT
		@RequestMapping("/engglogins/update/{contact_no}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Login_Model updateUserLogin(@PathVariable long contact_no,@RequestBody Login_Model um){
			um.setLoginNumber(contact_no);
			return loginService.updateEnggLoginByContact(um);
		}
		@POST
		@RequestMapping("/engglogins/validate/{contact_no}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public boolean getValidateStaus(@PathVariable long contact_no,@RequestBody Login_Model um){
			um.setLoginNumber(contact_no);
			System.out.println("cotroller contact : "+um.getLoginNumber()+" password :"+um.getLoginPassword());
			return loginService.getValidateStaus(um);
		}
}
