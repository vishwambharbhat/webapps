package com.Blog.posts.Services;

import java.util.List;

import com.Blog.posts.DbUtils.DbConnection;
import com.Blog.posts.model.PersonModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class PersonService {
	 DB db;
	public PersonService() {
		DbConnection dbutil=new DbConnection();
		db=dbutil.getDb();
	}
public void addPerson(PersonModel person){
DBCollection dbCollection=db.getCollection("person");


BasicDBObject doc=new BasicDBObject();
doc.put("firstname",person.getFirstName());
doc.put("lastname",person.getLastName());
doc.put("age",person.getAge());
doc.put("date_of_birth",person.getDate_of_birth());
doc.put("email_id",person.getEmial_id());
doc.put("username",person.getEmial_id());
doc.put("password",person.getPassword());

dbCollection.save(doc);

LoginService loginService =new LoginService();
loginService.addLogin(person.getEmial_id(), person.getPassword());

}

public List<PersonModel> getAllPerson(){
	return null;
	
}

public PersonModel getPersonByName(String person_id){
	PersonModel person =new PersonModel();
	
	DBCollection dbCollection=db.getCollection("person");
	
	BasicDBObject man=new BasicDBObject();
	man.put("username", person_id);
	
	DBCursor cursor =dbCollection.find(man);
	while(cursor.hasNext()){
		BasicDBObject tobj=(BasicDBObject)cursor.next();
		
		if(person_id.equals(tobj.getString("username"))){
			person.setFirstName(tobj.getString("firstname"));
			person.setLastName(tobj.getString("lastname"));
			person.setAge(tobj.getInt("age"));
			person.setDate_of_birth(tobj.getDate("date_of_birth"));
			person.setEmial_id(tobj.getString("email_id"));
			person.setPassword(tobj.getString("password"));
			break;
		}
	}
	return person;
}

public void deletePerson(String person_id){
	
}

public void updatePerson(PersonModel person){
	
	 BasicDBObject update=new BasicDBObject();
	 update.put("firstname",person.getFirstName());
	 update.put("lastname",person.getLastName());
	 update.put("age",person.getAge());
	 update.put("date_of_birth",person.getDate_of_birth());
	 update.put("email_id",person.getEmial_id());
	 update.put("username",person.getEmial_id());
	 update.put("password",person.getPassword());
     
		
		
		DBCollection dbCollection=db.getCollection("person");
     DBCursor cursor=dbCollection.find(update);
		
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
             BasicDBObject updateDoc=new BasicDBObject();
		updateDoc.append("$set",update);
             BasicDBObject searchQuery = new BasicDBObject().append("email_id", person.getEmial_id());
             dbCollection.update(searchQuery,updateDoc);
	
}

public boolean findPersonIfExists(PersonModel person){
	BasicDBObject persondata=new BasicDBObject();
	boolean bool=false;
	persondata.put("email_id",person.getEmial_id());
	
	DBCollection dbCollection=db.getCollection("person");
	DBCursor dbCursor=dbCollection.find(persondata);
	while(dbCursor.hasNext()){
		BasicDBObject tobj=(BasicDBObject)dbCursor.next();
		if(person.getEmial_id().equals(tobj.getString("email_id"))){
			bool=true;
			break;
		}
	}
	
	if(bool){
		return true;
	}
	return false;
}
}
