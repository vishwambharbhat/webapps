package com.Blog.posts.model;

public class Like_Model {
private String user_name;
private String post_title;
private boolean isLike;
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPost_title() {
	return post_title;
}
public void setPost_title(String post_title) {
	this.post_title = post_title;
}
public boolean isLike() {
	return isLike;
}
public void setLike(boolean isLike) {
	this.isLike = isLike;
}

}
