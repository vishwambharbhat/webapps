package com.Blog.posts.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.Blog.posts.DbUtils.DbConnection;
import com.Blog.posts.model.LoginModel;
import com.Blog.posts.model.PostModel;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class PostService {
	
	DB db;
	public PostService() {
		DbConnection dbutil=new DbConnection();
		db=dbutil.getDb();
	} 
public void addPost(PostModel post){
	DBCollection dbCollection=db.getCollection("MyPosts");
	
	BasicDBObject doc=new BasicDBObject();
	doc.put("post_title",post.getPost_title());
	doc.put("post_content", post.getPost_content());
	doc.put("date_of_post",new Date());
	doc.put("user",post.getUser_name());
	doc.put("comments",new ArrayList<>());
	doc.put("likes", 0);
	doc.put("shares",0);
	dbCollection.save(doc);
}
public List<PostModel> getAllPosts(){
	List<PostModel> listPost=new ArrayList<PostModel>();
	DBCollection dbCollection=db.getCollection("MyPosts");
	DBCursor cursor=dbCollection.find().sort(new BasicDBObject("date_of_post",-1));
	while(cursor.hasNext()){
	PostModel post= new PostModel();
	
	 BasicDBObject tobj = (BasicDBObject) cursor.next();
	 
	 
	 post.setPost_title(tobj.getString("post_title"));
	String post_title=post.getPost_title();
	 post.setPost_content(tobj.getString("post_content"));
	 //System.out.println(post.getPost_content());
	 post.setDate_of_post(tobj.getDate("date_of_post"));
	 post.setUser_name(tobj.getString("user"));
	 post.setLikes(tobj.getInt("likes"));
	// System.out.println(post.getDate_of_post());
	/* BasicDBList list = (BasicDBList) tobj.get("comments");
	 List list2=new ArrayList<>();
	 for(Object list3:list){
		 list2.add("________________________________________________________________________________________________________________________________________");
		 list2.add(((ArrayList) list3).get(0));
		 list2.add(((ArrayList) list3).get(1));
		 list2.add(((ArrayList) list3).get(3));
		 
	}
	 String format1="";
	 for(String format:list2){
		 format1+=format;
	 }
	 post.setComments(list2);*/
	 
	 CommentService commentService=new CommentService();
	 System.out.println("list of comments : "+commentService.getAllCommentsByPost(post_title ));
	 post.setComments(commentService.getAllCommentsByPost(post_title ));
	 listPost.add(post);
	 
	
	}
	return listPost;
}
public PostModel getPostById(String post_id){
PostModel post =new PostModel();
	
	DBCollection dbCollection=db.getCollection("MyPosts");
	BasicDBObject pst=new BasicDBObject();
	pst.put("post_title", post_id);
	DBCursor cursor =dbCollection.find(pst);
	while(cursor.hasNext()){
		BasicDBObject tobj=(BasicDBObject)cursor.next();
		
		 post.setPost_title(tobj.getString("post_title"));
			String post_title=post.getPost_title();
			 post.setPost_content(tobj.getString("post_content"));
			 //System.out.println(post.getPost_content());
			 post.setDate_of_post(tobj.getDate("date_of_post"));
			 post.setUser_name(tobj.getString("user"));
			 post.setLikes(tobj.getInt("likes"));
			 CommentService commentService=new CommentService();
			 System.out.println("list of comments : "+commentService.getAllCommentsByPost(post_title ));
			 post.setComments(commentService.getAllCommentsByPost(post_title ));
			 
	}
	return post;
}

public void deleteByPostId(String post_id){
DBCollection dbCollection=db.getCollection("MyPosts"); 
    
    BasicDBObject delete=new BasicDBObject();
    delete.put("post_title", post_id);
   
            dbCollection.remove(delete);
}

public void updatePost(PostModel post){
	
}
}
