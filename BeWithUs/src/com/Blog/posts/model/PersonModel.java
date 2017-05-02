package com.Blog.posts.model;

import java.util.Date;

public class PersonModel {
private String person_id;

private String firstName;
private String lastName;
private int age;
private Date date_of_birth;
private String emial_id;
String userName;
String password;

public String getPerson_id() {
	return person_id;
}
public void setPerson_id(String person_id) {
	this.person_id = person_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Date getDate_of_birth() {
	return date_of_birth;
}
public void setDate_of_birth(Date date_of_birth) {
	this.date_of_birth = date_of_birth;
}
public String getEmial_id() {
	return emial_id;
}
public void setEmial_id(String emial_id) {
	this.emial_id = emial_id;
}

}
