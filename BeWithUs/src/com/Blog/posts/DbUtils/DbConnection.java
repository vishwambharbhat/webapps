package com.Blog.posts.DbUtils;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class DbConnection {
	private Mongo mongo=null;
	private	DB db=null;
	public DbConnection(){
	
	
	
	mongo=new Mongo("localhost",27017);
	
	db=mongo.getDB("blogwriting");
	}
	
	public DB getDb(){
		return db;
	}
}
