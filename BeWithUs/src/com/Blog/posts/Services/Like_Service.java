package com.Blog.posts.Services;

import com.Blog.posts.DbUtils.DbConnection;
import com.Blog.posts.model.Like_Model;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class Like_Service {
	 DB db;
public Like_Service() {
	DbConnection dbutil=new DbConnection();
	db=dbutil.getDb();
}

public void setLikes(Like_Model like){
	DBCollection dbCollection1=db.getCollection("like_post_user");
	BasicDBObject whereQuery = new BasicDBObject();
	whereQuery.put("user", like.getUser_name());
	whereQuery.put("post_title", like.getPost_title());
	boolean ifTrue=false;
	DBCursor cursor = dbCollection1.find(whereQuery);
	while(cursor.hasNext()) {
	   BasicDBObject tobj=(BasicDBObject)cursor.next();
	   if(like.getPost_title().equals(tobj.getString("post_title"))&&like.getUser_name().equals(tobj.getString("user"))){
	   ifTrue=tobj.getBoolean("liked");
	   break;
	   }
	}
	if(!ifTrue){
	BasicDBObject doc1=new BasicDBObject();
	
	doc1.put("user", like.getUser_name());
	doc1.put("post_title",like.getPost_title());
	doc1.put("liked",like.isLike());
	
	dbCollection1.save(doc1);
	
	DBCollection dbCollection2=db.getCollection("MyPosts");
	
	BasicDBObject newDocument =
			new BasicDBObject().append("$inc",new BasicDBObject().append("likes", 1));

		dbCollection2.update(new BasicDBObject().append("post_title", like.getPost_title()), newDocument);
	}
}
}
