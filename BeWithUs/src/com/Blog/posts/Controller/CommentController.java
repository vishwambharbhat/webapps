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

import com.Blog.posts.Services.CommentService;
import com.Blog.posts.Services.LoginService;
import com.Blog.posts.Services.PersonService;
import com.Blog.posts.Services.PostService;
import com.Blog.posts.model.Comment_model;
import com.Blog.posts.model.PostModel;


public class CommentController extends HttpServlet {
	CommentService commentService;
	public CommentController() {
		commentService=new CommentService();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	Comment_model comment=new Comment_model();
	comment.setComment_content(request.getParameter("mycommnents"));
	comment.setUserName(request.getParameter("cmtr"));
	comment.setPostId(request.getParameter("post_id"));
	
	commentService.addComment(comment);
	
try {
		HttpSession session=request.getSession();
		
		request.setAttribute("message","<h4 style=\"color:#3b5134;\"><b> Hi,"+session.getAttribute("userid").toString()+"</b></h4>");
		RequestDispatcher view = request.getRequestDispatcher("MyBlog.jsp");
		List<PostModel> list= new ArrayList<PostModel>();
		list=new PostService().getAllPosts();
		System.out.println(list);
	    request.setAttribute("posts", list);
	    request.setAttribute("user", new PersonService().getPersonByName(session.getAttribute("userid").toString()));
	    view.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
