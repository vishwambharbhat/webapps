package com.Blog.posts.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Blog.posts.Services.LoginService;
import com.Blog.posts.Services.PersonService;
import com.Blog.posts.Services.PostService;
import com.Blog.posts.model.LoginModel;
import com.Blog.posts.model.PersonModel;
import com.Blog.posts.model.PostModel;

public class LoginController extends HttpServlet{
	LoginService loginService;
	public LoginController() {
		loginService=new LoginService();
	}
public void doPost(HttpServletRequest request,HttpServletResponse response){
	LoginModel login=new LoginModel();
	login.setUserName(request.getParameter("name"));
	login.setUserPassword(request.getParameter("pass"));
	
	login.setLogin_id(loginService.validateLogin(login));
	if(login.getLogin_id()==null){
		try {
			request.setAttribute("message","<h4 style=\"color:#f00;\"><b>Invalid Username or password</b></h4>");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else{
		try {
			HttpSession session=request.getSession();
			session.setAttribute("userid", login.getUserName());
			request.setAttribute("message","<h4 style=\"color:#3b5134;\"><b> Hi,"+login.getUserName()+"</b></h4>");
			RequestDispatcher view = request.getRequestDispatcher("MyBlog.jsp");
			List<PostModel> list= new ArrayList<PostModel>();
			
			list=new PostService().getAllPosts();
			System.out.println(list);
		    request.setAttribute("posts", list);
		    request.setAttribute("user", new PersonService().getPersonByName(login.getUserName()));
		    view.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
