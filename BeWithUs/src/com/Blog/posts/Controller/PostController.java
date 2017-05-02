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
import com.Blog.posts.model.PostModel;

public class PostController extends HttpServlet{
	PostService postService;
	LoginService loginService;
	public PostController() {
		postService=new PostService();
		loginService=new LoginService();
	}
	HttpSession session;
	String action;
	String login_id;
public void doGet(HttpServletRequest request,HttpServletResponse response){
	 session=request.getSession();
	 login_id=session.getAttribute("userid").toString();
	
	
	
	action =request.getParameter("action");

	System.out.println("action = "+action);
	if(action.equals("delete")){
		String uid=request.getParameter("uid");
		System.out.println("uuid  : "+uid);
		String authid=request.getParameter("authid");
		System.out.println("auth id : "+authid);
		if(uid.equals(authid)){
			String pid=request.getParameter("pid");
			System.out.println("post id : "+pid);
			postService.deleteByPostId(pid);
		}
		

		try {
			
			request.setAttribute("message","<h4 style=\"color:#3b5134;\"><b> Hi,"+login_id+"</b></h4>");
			RequestDispatcher view = request.getRequestDispatcher("MyBlog.jsp");
			List<PostModel> list= new ArrayList<PostModel>();
			list=new PostService().getAllPosts();
			request.setAttribute("posts", list);
		    view.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(action.equals("getpost")){
		String pid=request.getParameter("postid");
		
		
		try {
			
		
			RequestDispatcher view = request.getRequestDispatcher("Post.jsp");
			PostModel model=postService.getPostById(pid);
			request.setAttribute("post",model );
		    view.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
public void doPost(HttpServletRequest request,HttpServletResponse response){
	if(session==null){
		 session=request.getSession();
		 login_id=session.getAttribute("userid").toString();
	}

	PostModel post=new PostModel();
	post.setPost_title(request.getParameter("title"));
	post.setPost_content(request.getParameter("postcontent"));
	post.setUser_name(login_id);
postService.addPost(post);
	
	try {
		
		request.setAttribute("message","<h4 style=\"color:#3b5134;\"><b> Hi,"+login_id+"</b></h4>");
		RequestDispatcher view = request.getRequestDispatcher("MyBlog.jsp");
		List<PostModel> list= new ArrayList<PostModel>();
		list=new PostService().getAllPosts();
		request.setAttribute("posts", list);
	    view.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
