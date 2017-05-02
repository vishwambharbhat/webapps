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

import com.Blog.posts.Services.Like_Service;
import com.Blog.posts.Services.PostService;
import com.Blog.posts.model.Like_Model;
import com.Blog.posts.model.PostModel;

public class LikeController extends HttpServlet {
	Like_Service like_Service;
	public LikeController() {
		like_Service=new Like_Service();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	String action=request.getParameter("action");
	Like_Model like_Model=new Like_Model();
	if(action.equals("like")){
		
		like_Model.setPost_title(request.getParameter("pid"));
		like_Model.setUser_name(request.getParameter("uid"));
		like_Model.setLike(true);
		like_Service.setLikes(like_Model);
		
	}
	
	try {
		HttpSession session=request.getSession();
		
		request.setAttribute("message","<h4 style=\"color:#3b5134;\"><b> Hi,"+session.getAttribute("userid")+"</b></h4>");
		RequestDispatcher view = request.getRequestDispatcher("MyBlog.jsp");
		List<PostModel> list= new ArrayList<PostModel>();
		list=new PostService().getAllPosts();
		System.out.println(list);
	    request.setAttribute("posts", list);
	    view.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
