package com.Blog.posts.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.posts.Services.PersonService;
import com.Blog.posts.model.PersonModel;

public class PersonController extends HttpServlet {
	private PersonService personService=null;
	public PersonController() {
		personService =new PersonService();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	
}

public void doPost(HttpServletRequest request,HttpServletResponse response){
	String date_string=request.getParameter("dob");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date_util=null;
	System.out.println(date_string);
	try {
		date_util=formatter.parse(date_string);
		
		System.out.println(date_util);
		
		System.out.println(new Date());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PersonModel person=new PersonModel();
	person.setFirstName(request.getParameter("firstname"));
	person.setLastName(request.getParameter("lastname"));
	person.setAge(Integer.parseInt(request.getParameter("age")));
	person.setDate_of_birth(date_util);
	person.setEmial_id(request.getParameter("email"));
	person.setUserName(request.getParameter("email"));
	person.setPassword(request.getParameter("password"));
	boolean bool=personService.findPersonIfExists(person);
	if(!bool){
	personService.addPerson(person);
	}
	else{
		personService.updatePerson(person);
	}
	try {
		request.setAttribute("message","<h4 style=\"color:#3b5134;\"><b>Added new User Successfully</b></h4>");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
