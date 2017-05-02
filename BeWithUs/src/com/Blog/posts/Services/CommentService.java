package com.Blog.posts.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Blog.posts.DbUtils.DbConnection;
import com.Blog.posts.model.Comment_model;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCallback;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CommentService {
	DB db;
	public CommentService() {
		DbConnection dbutil=new DbConnection();
		db=dbutil.getDb();
	} 
public void addComment(Comment_model comment){
	
	DBCollection dbCollection=db.getCollection("Comments");
	
	BasicDBObject doc=new BasicDBObject();
	doc.put("comment_content", comment.getComment_content());
	doc.put("user_name", comment.getUserName());
	doc.put("post_id", comment.getPostId());
	doc.put("date_of_comment", new Date());
	doc.put("likes", 0);
	doc.put("shares", 0);
	
	dbCollection.save(doc);
	
	/*List commentDetails=new ArrayList<>();
	
	commentDetails.add(comment.getComment_content());
	commentDetails.add(comment.getUserName());
	commentDetails.add(comment.getPostId());
	commentDetails.add(new Date());*/
	
	String commentid="";
	BasicDBObject commentidsearch=new BasicDBObject();
	commentidsearch.put("comment_content", comment.getComment_content());
	DBCursor dbCursor=dbCollection.find(commentidsearch);
	while(dbCursor.hasNext()){
		BasicDBObject tobj=(BasicDBObject)dbCursor.next();
		if(comment.getComment_content().equals(tobj.getString("comment_content"))){
			commentid=tobj.getString("_id");
			break;
		}
	}
	
	DBCollection dbCollection2=db.getCollection("MyPosts");
	
	List<String> listOfIds=new ArrayList<String>();
	listOfIds.add(commentid);
	BasicDBObject newDocument = new BasicDBObject();
	newDocument.append("$push", new BasicDBObject().append("comments", listOfIds));

	BasicDBObject searchQuery = new BasicDBObject().append("post_title",comment.getPostId() );

	dbCollection2.update(searchQuery, newDocument);
}
public List<Comment_model> getAllCommentsByPost(String post_title) {
	
	DBCollection dbCollection2=db.getCollection("Comments"); 
	
	List<Comment_model> allComments =new ArrayList<Comment_model>();
	BasicDBObject title_query=new BasicDBObject();
	title_query.put("post_id", post_title);
	DBCursor cursor=dbCollection2.find(title_query);
	
	while(cursor.hasNext()){
		BasicDBObject tobj=(BasicDBObject)cursor.next();
		Comment_model comment=new Comment_model();
		comment.setComment_content(tobj.getString("comment_content"));
		comment.setDate_of_comment(tobj.getDate("date_of_comment"));
		comment.setUserName(tobj.getString("user_name"));
		comment.setLikes(tobj.getInt("likes"));
		comment.setShares(tobj.getInt("shares"));
		
		allComments.add(comment);
	}
	return allComments;
}
}
