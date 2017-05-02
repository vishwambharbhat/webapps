package com.Blog.posts.Services;

import com.Blog.posts.DbUtils.DbConnection;
import com.Blog.posts.model.LoginModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class LoginService {
	
	 DB db;
	 public LoginService() {
		 DbConnection dbutil=new DbConnection();
			db=dbutil.getDb();
	}
public void addLogin(String userName,String userPassword){
	DBCollection dbCollection=db.getCollection("login");
	
	BasicDBObject doc =new BasicDBObject(); 
	doc.put("username",userName);
	doc.put("password",userPassword);

	dbCollection.save(doc);
}

public String validateLogin(LoginModel login){
	String id=null;
	DBCollection dbCollection=db.getCollection("login");
	String status="invalid";
	DBCursor cursor=dbCollection.find(); 
	while(cursor.hasNext()){
		 BasicDBObject tobj = (BasicDBObject) cursor.next();
		if(login.getUserName().equals(tobj.getString("username"))&&login.getUserPassword().equals(tobj.getString("password"))){
		status="valid";
		id=tobj.getString("_id");
		break;
		}
	}
	if(status.equals("valid")){
		return id;
	}
	return id;
	}

public String getLoginName(String login_id){
	String userName=null;
	System.out.println(login_id);
	DBCollection dbCollection=db.getCollection("login");
	BasicDBObject query=new BasicDBObject();
	BasicDBObject search=new BasicDBObject();
	search.put("_id",login_id);
	 DBCursor cursor=dbCollection.find(query,search);
	 
	 while(cursor.hasNext()){
		 
		 BasicDBObject tobj = (BasicDBObject) cursor.next();
		
		
		 if(login_id.equals(tobj.getString("_id"))){
			 System.out.println("from database "+tobj.getString("_id"));
		userName=tobj.getString("username");
		System.out.println(tobj.getString("username"));
		break;
		}
		 
	 }
	 
	 if(userName!=null){
		 return userName;
	 }
	
	return null;
}
}
